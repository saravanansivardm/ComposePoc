package com.example.pocofdigivalapp.mycourse

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.pocofdigivalapp.data.course.CourseItem
import com.example.pocofdigivalapp.data.institutionCalendar.InstitutionCalendarList

@Composable
fun MycourseListRoute(
    viewModel: CourseListViewModel,
    courseList: List<CourseItem>,
    academicYearList: List<InstitutionCalendarList>,
    onAcademicYearSelected: (String) -> Unit,
) {
    Log.e("courseList_loggg", courseList.toString())
    val uiState by viewModel.uiState.collectAsState()
    when (uiState) {
        is MycourseListState.Ideal -> {
            MyCourseListScreen(
                courseList = courseList,
                academicYearList = academicYearList,
                requestInProgress = false,
                onAcademicYearSelected = onAcademicYearSelected,
                loadingProgress = viewModel.loading.value,
                tabTitles = viewModel.tabTitles,
                onValueChanged = { viewModel.searchCoursesList(it) },
                onTabSelectedPosition = { viewModel.selectedList(it) },
            )
        }
        is MycourseListState.Loading -> {
            MyCourseListScreen(
                courseList = courseList,
                academicYearList = academicYearList,
                requestInProgress = true,
                onAcademicYearSelected = onAcademicYearSelected,
                loadingProgress = viewModel.loading.value,
                tabTitles = viewModel.tabTitles,
                onValueChanged = { viewModel.searchCoursesList(it) },
                onTabSelectedPosition = { viewModel.selectedList(it) },
            )
        }
    }
}

