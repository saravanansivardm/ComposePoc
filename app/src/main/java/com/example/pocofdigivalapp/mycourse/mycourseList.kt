package com.example.pocofdigivalapp.mycourse

import android.widget.Toast
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
import com.example.pocofdigivalapp.utils.CircularProgressBar
import com.example.pocofdigivalapp.utils.ratingBar.CustomRatingBar
import com.example.pocofdigivalapp.data.course.CourseItem
import com.example.pocofdigivalapp.data.institutionCalendar.InstitutionCalendarList
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay


@Preview(showBackground = false)
@Composable
private fun MyCourseListScreenPreview() {
    MyCourseListScreen(
        courseList = listOf(),
        academicYearList = listOf(),
        requestInProgress = false,
        onAcademicYearSelected = {},
        loadingProgress = false,
        tabTitles = listOf("All", "Starred"),
        onValueChanged = {},
        onTabSelectedPosition = {},
    )
}

@Composable
fun MyCourseListScreen(
    courseList: List<CourseItem>,
    academicYearList: List<InstitutionCalendarList>,
    requestInProgress: Boolean,
    onAcademicYearSelected: (String) -> Unit,
    loadingProgress: Boolean,
    tabTitles: List<String>,
    onValueChanged: (String) -> Unit,
    onTabSelectedPosition: (Int) -> Unit,
) {
    var openDialog by remember { mutableStateOf(false) }
    var selecetedYear by remember { mutableStateOf("") }
    var refreshing by remember { mutableStateOf(false) }

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
                    onAcademicYearSelected = {
                        selecetedYear = it
                    },
                    academicYearList,
                )
                ToolbarForMyCourseList(
                    tabTitles = tabTitles,
                    onValueChanged = onValueChanged,
                    onTabSelectedPosition = onTabSelectedPosition,
                )
                AcademicYearView(
                    academicYearList,
                    selecetedYear,
                ) {
                    openDialog = it
                }
                Spacer(modifier = Modifier.padding(top = 16.dp))
                LaunchedEffect(refreshing) {
                    if (refreshing) {
                        delay(2000)
                        refreshing = false
                    }
                }
                Box(modifier = Modifier.fillMaxSize()) {
                    SwipeRefresh(
                        state = rememberSwipeRefreshState(isRefreshing = refreshing),
                        onRefresh = { refreshing = true },
                        indicator = { refreshing, refreshTrigger ->
                            SwipeRefreshIndicator(
                                state = refreshing, refreshTriggerDistance = refreshTrigger,
                                scale = true,
                                backgroundColor = colorResource(id = R.color.grey_200),
                                contentColor = colorResource(id = R.color.digi_blue)
                            )
                        }
                    ) {
                        LazyColumn {
                            itemsIndexed(items = courseList) { index, courseList ->
                                CardViewForCourseList(courseList, onclick = {})
                            }
                        }
                        CircularProgressBar(isDisplayed = loadingProgress)
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
    onAcademicYearSelected: (String) -> Unit,
    academicYearList: List<InstitutionCalendarList>,
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
                        for (yearsList in academicYearList) {
                            Text(
                                text = yearsList.calendarName.toString(),
                                modifier = Modifier
                                    .padding(top = 8.dp)
                                    .clickable(
                                        onClick = {
                                            onDismissDialog(false)
                                            onAcademicYearSelected(yearsList.calendarName.toString())
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
    academicYearList: List<InstitutionCalendarList>,
    selectedYear: String,
    onDismissDialog: (Boolean) -> Unit,
) {
    var academicYearFirstPosition = ""
    academicYearFirstPosition = if (selectedYear.isEmpty())
        stringResource(R.string.academic_year_str, academicYearList[0].calendarName.toString())
    else stringResource(R.string.academic_year_str, selectedYear)
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
    onValueChanged: (String) -> Unit,
    onTabSelectedPosition: (Int) -> Unit,
) {
    var text by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    var tabPosition by remember {
        mutableStateOf("")
    }
    Box {
        CollapsingToolbarBar(
            title = stringResource(id = R.string.my_courses),
            searchText = text,
            onSearchValueChanged = {
                text = it
                onValueChanged(text)
            },
            onBackPressed = {
                Toast.makeText(
                    context,
                    "onBackPressed_clicked",
                    Toast.LENGTH_SHORT
                )
                    .show()
            },
            tabTitles = tabTitles,
            onTabSelected = {
                tabPosition = it.toString()
                onTabSelectedPosition(it)
            },
            selectedTab = if (tabPosition.isEmpty()) 3 else tabPosition.toInt()
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

