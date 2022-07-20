package com.example.pocofdigivalapp.studentmycourses

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.data.studentinstitutionCalendar.StudentInstitutionCalendarList
import com.example.pocofdigivalapp.data.studentmycourse.StudentCourseItem
import com.example.pocofdigivalapp.utils.CircularProgressBar
import com.example.pocofdigivalapp.utils.ratingBar.CustomRatingBar
import com.example.pocofdigivalapp.utils.valueOrDefault
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Preview(showBackground = true)
@Composable
private fun StudentMyCourseListScreenPreview() {
    StudentMyCourseListScreen(
        isLoading = false,
        courseList = listOf(),
        tabPosition = 3,
        searchValue = "",
        onSearchValueChanged = {},
        onTabSelectedPosition = {},
        initialCalendar = "",
        institutionCalendarList = listOf(),
        onAcademicYearSelected = {},
        onRefreshing = {},
        isRefreshing = false,
        onClick = {},
        onBackPress = {},
    )
}

@Composable
fun StudentMyCourseListScreen(
    isLoading: Boolean,
    courseList: List<StudentCourseItem>,
    tabPosition: Int,
    searchValue: String,
    onSearchValueChanged: (String) -> Unit,
    onTabSelectedPosition: (Int) -> Unit,
    initialCalendar: String,
    institutionCalendarList: List<StudentInstitutionCalendarList>,
    onAcademicYearSelected: (StudentInstitutionCalendarList) -> Unit,
    onRefreshing: (Boolean) -> Unit,
    isRefreshing: Boolean,
    onClick: () -> Unit,
    onBackPress: () -> Unit,
) {
    var openDialog by remember { mutableStateOf(false) }
    val tabTitles = listOf(
        stringResource(id = R.string.completed_txt),
        stringResource(id = R.string.to_start),
        stringResource(id = R.string.in_progress),
        stringResource(id = R.string.all)
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = colorResource(R.color.light_grey_color),
        content = {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AcademicYearSelectionDialog(
                    openDialog = openDialog,
                    onDismissDialog = {
                        openDialog = it
                    },
                    onAcademicYearSelected = onAcademicYearSelected,
                    institutionCalendarList = institutionCalendarList,
                )
                ToolbarForMyCourseList(
                    tabTitles = tabTitles,
                    searchValue = searchValue,
                    tabPosition = tabPosition,
                    onSearchValueChanged = onSearchValueChanged,
                    onTabSelectedPosition = onTabSelectedPosition,
                    onBackPress = onBackPress,
                )
                AcademicYearView(
                    institutionCalendarList = institutionCalendarList,
                    initialCalendar,
                ) {
                    openDialog = it
                }
                Spacer(modifier = Modifier.padding(top = 16.dp))
                Box(modifier = Modifier.fillMaxSize()) {
                    SwipeRefresh(
                        state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
                        onRefresh = { onRefreshing(true) },
                        indicator = { refreshing, refreshTrigger ->
                            SwipeRefreshIndicator(
                                state = refreshing, refreshTriggerDistance = refreshTrigger,
                                scale = true,
                                backgroundColor = colorResource(id = R.color.grey_200),
                                contentColor = colorResource(id = R.color.digi_blue)
                            )
                        }
                    ) {
                        if (courseList.isEmpty() && !isLoading) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = stringResource(id = R.string.no_courses_found),
                                    fontSize = 18.sp,
                                    color = Color.Black.copy(0.5f),
                                    fontWeight = FontWeight.Normal,
                                )
                            }
                        } else {
                            LazyColumn {
                                itemsIndexed(items = courseList) { index, courseList ->
                                    StudentCardViewForMyCourseList(
                                        courseList,
                                        onclick = { onClick() })
                                }
                            }
                        }
                        CircularProgressBar(isDisplayed = isLoading && !isRefreshing)
                    }
                }
            }
        }
    )
}

@Composable
fun AcademicYearSelectionDialog(
    openDialog: Boolean,
    onDismissDialog: (Boolean) -> Unit,
    onAcademicYearSelected: (StudentInstitutionCalendarList) -> Unit,
    institutionCalendarList: List<StudentInstitutionCalendarList>,
) {
    MaterialTheme {
        if (openDialog) {
            AlertDialog(
                backgroundColor = Color.White,
                onDismissRequest = {
                    onDismissDialog(false)
                },
                title = {
                    Text(
                        text = stringResource(id = R.string.academic_year),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(end = 15.dp),
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                    )
                },
                text = {
                    Column(modifier = Modifier.padding(top = 15.dp)) {
                        for (yearsList in institutionCalendarList) {
                            Text(
                                text = yearsList.calendarName.toString(),
                                modifier = Modifier
                                    .padding(top = 8.dp)
                                    .clickable(
                                        onClick = {
                                            onDismissDialog(false)
                                            onAcademicYearSelected(yearsList)
                                        }
                                    ),
                                fontSize = 16.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Normal,
                            )
                        }
                    }
                },
                confirmButton = {},
                dismissButton = {}
            )
        }
    }
}

@Composable
fun AcademicYearView(
    institutionCalendarList: List<StudentInstitutionCalendarList>,
    initialCalendar: String,
    onDismissDialog: (Boolean) -> Unit,
) {
    var academicYearFirstPosition = ""
    academicYearFirstPosition = if (initialCalendar.isEmpty())
        stringResource(
            R.string.academic_year_str,
            institutionCalendarList[0].calendarName.valueOrDefault()
        )
    else stringResource(R.string.academic_year_str, initialCalendar)
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = Color.White)
            .clickable {
                onDismissDialog(true)
            }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = academicYearFirstPosition,
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(start = 10.dp)
            )
            Icon(
                painterResource(id = R.drawable.ic_drop_down_black), tint = Color.Black,
                contentDescription = "Password Toggle",
                modifier = Modifier
                    .padding(top = 11.dp)
                    .align(Alignment.Bottom),
            )
        }
    }
}

@Composable
fun ToolbarForMyCourseList(
    tabTitles: List<String>,
    tabPosition: Int,
    searchValue: String,
    onSearchValueChanged: (String) -> Unit,
    onTabSelectedPosition: (Int) -> Unit,
    onBackPress: () -> Unit,
) {

    val context = LocalContext.current

    Box {
        StudentCollapsingToolBar(
            title = stringResource(id = R.string.my_courses),
            searchText = searchValue,
            onSearchValueChanged = {
                onSearchValueChanged(it)
            },
            onBackPressed = {
                onBackPress()
            },
            tabTitles = tabTitles,
            onTabSelected = {
                onTabSelectedPosition(it)
            },
            selectedTab = tabPosition
        )
    }
}

@Composable
fun RatingBarView(
    ratingValue: Float
) {
    val rating: Float by rememberSaveable { mutableStateOf(ratingValue) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        CustomRatingBar(
            value = rating,
        )
    }
}

