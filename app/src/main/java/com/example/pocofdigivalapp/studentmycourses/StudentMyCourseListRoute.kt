package com.example.pocofdigivalapp.studentmycourses

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.pocofdigivalapp.utils.valueOrDefault

@Composable
fun StudentMyCourseListRoute(
    viewModel: StudentCourseListViewModel,
) {
    val uiState by viewModel.uiState.collectAsState()
    StudentMyCourseListScreen(
        isLoading = uiState.isLoading.valueOrDefault(),
        courseList = uiState.courseList.toList(),
        initialCalendar = viewModel.initialCalendar,
        institutionCalendarList = uiState.studentInstitutionCalendarList.toList(),
        onAcademicYearSelected = { viewModel.setCalendarList(it) },
        tabPosition = viewModel.tabPosition,
        searchValue = viewModel.searchValue,
        onSearchValueChanged = { viewModel.searchCoursesList(it) },
        onTabSelectedPosition = { viewModel.onTabSelected(it) },
        onRefreshing = { viewModel.onRefreshing(it) },
        isRefreshing = viewModel.isRefreshing,
        onClick = { viewModel.navigateToSchedule() },
        onBackPress = { viewModel.backPress() }
    )
}

