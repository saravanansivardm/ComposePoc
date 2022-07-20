package com.example.pocofdigivalapp.studentmycourses

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocofdigivalapp.api.CustomResponse
import com.example.pocofdigivalapp.data.studentinstitutionCalendar.StudentInstitutionCalendarList
import com.example.pocofdigivalapp.data.studentmycourse.StudentCourseItem
import com.example.pocofdigivalapp.repository.AuthRepo
import com.example.pocofdigivalapp.utils.valueOrDefault
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class StudentCourseListViewModel(
    private val authRepo: AuthRepo,
) : ViewModel() {

    private val viewModelState = MutableStateFlow(
        StudentMyCourseViewModelState(isLoading = true)
    )

    var tabPosition by mutableStateOf(3)
        private set

    var searchValue by mutableStateOf("")
        private set

    private var institutionCalendarId by mutableStateOf("")
        private set

    var initialCalendar by mutableStateOf("")
        private set

    private var cachedCourseList = listOf<StudentCourseItem>()

    var isRefreshing by mutableStateOf(false)
        private set

    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(viewModelScope, SharingStarted.Eagerly, viewModelState.value.toUiState())

    init {
        getStudentAcademicYearList()
        getStudentMyCourseList()
    }

    private fun getStudentAcademicYearList() {
        viewModelScope.launch {
            when (val response = authRepo.getStudentAcademicYearResponse()) {
                is CustomResponse.Success -> {
                    institutionCalendarId = response.data.dataList.get(0).id.valueOrDefault()
                    viewModelState.update {
                        it.copy(studentInstitutionCalendarList = response.data.dataList)
                    }
                }
                is CustomResponse.Failure -> {
                    viewModelState.update { it.copy(isLoading = false) }
                }
            }
        }
    }

    private fun getStudentMyCourseList() {
        viewModelScope.launch {
            delay(4000)
            when (val response = authRepo.getStudentMyCourseListResponse()) {
                is CustomResponse.Success -> {
                    cachedCourseList = response.data.courseList
                    onRefreshing(false)
                    viewModelState.update {
                        it.copy(
                            isLoading = false,
                            courseList = response.data.courseList
                        )
                    }
                }
                is CustomResponse.Failure -> {
                    viewModelState.update { it.copy(isLoading = false) }
                }
            }
        }
    }

    fun searchCoursesList(query: String) {
        searchValue = query
        viewModelScope.launch {
            if (searchValue.isEmpty()) {
                viewModelState.update {
                    it.copy(courseList = cachedCourseList)
                }
            } else {
                val results = cachedCourseList.filter {
                    it.courseName?.contains(query.trim(), ignoreCase = true) == true ||
                            it.courseCode?.contains(query.trim(), ignoreCase = true) == true
                }
                viewModelState.update {
                    it.copy(courseList = results)
                }
            }
        }
    }

    fun setCalendarList(studentInstitutionCalendarList: StudentInstitutionCalendarList) {
        initialCalendar = studentInstitutionCalendarList.calendarName.valueOrDefault()
        institutionCalendarId = studentInstitutionCalendarList.id.valueOrDefault()
        viewModelState.update {
            it.copy(isLoading = true)
        }
        tabPosition = 3
        getStudentMyCourseList()
    }

    fun onTabSelected(position: Int) {
        tabPosition = position
        Log.e("position_log", position.toString())
        val filteredList: ArrayList<StudentCourseItem> = arrayListOf()
        val elements = cachedCourseList
        for (data in elements) {
            val completed = data.completedSessions ?: 0
            val total = data.totalSessions ?: 0
//            Log.e("status_log", status.toString())
            when (tabPosition) {
                0 -> {
                    if (completed == 0) {
                        filteredList.add(data)
                        Log.e("completed_list_log", filteredList.toString())
                    }
                }
                1 -> {
                    if (total == completed) {
                        filteredList.add(data)
                        Log.e("pending_list_log", filteredList.toString())
                    }
                }
                2 -> {
                    if (total != completed && completed != 0) {
                        filteredList.add(data)
                        Log.e("ongoing_list_log", filteredList.toString())
                    }
                }
                else -> {
                    filteredList.addAll(elements)
                    Log.e("all_list_log", filteredList.toString())
                    break
                }
            }
        }
        viewModelState.update {
            it.copy(courseList = filteredList)
        }
    }

    fun onRefreshing(refreshingState: Boolean) {
        isRefreshing = refreshingState
        if (isRefreshing) {
            viewModelState.update {
                it.copy(isLoading = isRefreshing)
            }
            getStudentMyCourseList()
            tabPosition = 3
        }
    }

    fun navigateToSchedule() {
//        Log.e("nextScreen", "clicked")
    }

    fun backPress() {
//        Log.e("backPress", "clicked")
    }
}


data class StudentMyCourseViewModelState(
    val isLoading: Boolean = false,
    val courseList: List<StudentCourseItem> = arrayListOf(),
    val studentInstitutionCalendarList: ArrayList<StudentInstitutionCalendarList> = arrayListOf(),
) {
    fun toUiState() = StudentMyCourseUiState(
        isLoading = isLoading,
        courseList = courseList,
        studentInstitutionCalendarList = studentInstitutionCalendarList,
    )
}

data class StudentMyCourseUiState(
    val isLoading: Boolean?,
    val courseList: List<StudentCourseItem>,
    val studentInstitutionCalendarList: ArrayList<StudentInstitutionCalendarList>
)

