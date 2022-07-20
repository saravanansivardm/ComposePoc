package com.example.pocofdigivalapp.dashboard

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocofdigivalapp.CourseListState
import com.example.pocofdigivalapp.api.CustomResponse
import com.example.pocofdigivalapp.data.course.CourseItem
import com.example.pocofdigivalapp.repository.DashboardRepo
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(private val dashboardRepo: DashboardRepo) : ViewModel() {
    private val viewModelState = MutableStateFlow(
        HomeViewModelState(isLoading = false)
    )
    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(viewModelScope, SharingStarted.Eagerly, viewModelState.value.toUiState())
    val loading = mutableStateOf(false)
    private val _myCourseListState: MutableState<CourseListState> = mutableStateOf(CourseListState.Loading)
    val courseList: MutableState<List<CourseItem>> = mutableStateOf(ArrayList())
    init {
        getMyCourseList()
    }

    fun getMyCourseList() {
        viewModelScope.launch {
            _myCourseListState.value = CourseListState.Loading
            loading.value = true
            delay(4000)
            when (val response = dashboardRepo.getDashboardMyCourseResponse()) {
                is CustomResponse.Success -> {
                    courseList.value = response.data.courseList
                    loading.value = false
                }
                is CustomResponse.Failure -> {
                    _myCourseListState.value = CourseListState.Failed(response.error)
                    loading.value = false
                }
            }
        }
    }
}


sealed class DashboardMyCourseListState {
    object Ideal : DashboardMyCourseListState()
    object Loading : DashboardMyCourseListState()
}

data class HomeViewModelState(
    val isLoading: Boolean = false,
) {
    fun toUiState(): DashboardMyCourseListState {
        return when {
            isLoading -> DashboardMyCourseListState.Loading
            else -> DashboardMyCourseListState.Ideal
        }
    }
}
