package com.example.pocofdigivalapp.mycourse

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocofdigivalapp.AcademicYearListState
import com.example.pocofdigivalapp.CourseListState
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.api.CustomResponse
import com.example.pocofdigivalapp.data.course.CourseItem
import com.example.pocofdigivalapp.data.institutionCalendar.InstitutionCalendarList
import com.example.pocofdigivalapp.repository.AuthRepo
import com.example.pocofdigivalapp.utils.CoursesTabs
import com.example.pocofdigivalapp.utils.getAfterDate
import com.example.pocofdigivalapp.utils.getTwoDigit
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class CourseListViewModel(
    private val authRepo: AuthRepo,
) : ViewModel() {
    private val viewModelState = MutableStateFlow(
        MycourseViewmodelState(isLoading = false)
    )
    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(viewModelScope, SharingStarted.Eagerly, viewModelState.value.toUiState())

    private val _myCourseListState: MutableState<CourseListState> = mutableStateOf(CourseListState.Loading)
    val courseList: MutableState<List<CourseItem>> = mutableStateOf(ArrayList())

    private val _academicYearListState: MutableState<AcademicYearListState> =
        mutableStateOf(AcademicYearListState.Loading)
    val academicYearList: MutableState<List<InstitutionCalendarList>> =
        mutableStateOf(ArrayList())

    val loading = mutableStateOf(false)
    val institutionCalendarId = mutableStateOf("")

    var tabTitles by mutableStateOf(
        listOf(
            "Completed",
            "To Start",
            "In Progress",
            "All"
        )
    )
    private val query = mutableStateOf("")

    private val selectedCategory: MutableState<CoursesTabs?> = mutableStateOf(null)
    private var cachedCourseList = listOf<CourseItem>()
    private var isSearchStarting = true
    var isSearching = mutableStateOf(false)
    var selectCourseItem: ArrayList<CourseItem?>? = arrayListOf()

    init {
        getMyCourseList()
        getAcademicYearList()
    }

    fun searchCoursesList(query: String) {
        val listToSearch = if (isSearchStarting) {
            courseList.value
        } else {
            cachedCourseList
        }
        viewModelScope.launch {
            if (query.isEmpty()) {
                courseList.value = cachedCourseList
                isSearching.value = true
                isSearchStarting = true
                return@launch
            } else {
                cachedCourseList
            }
            val results = listToSearch.filter {
                it.courseName?.contains(query.trim(), ignoreCase = true) == true
            }
            if (isSearchStarting) {
                cachedCourseList = courseList.value
                isSearchStarting = false
            }
            courseList.value = results
            isSearching.value = true
        }
    }

    fun getMyCourseList() {
//        Log.e("isSearching_loggg", isSearching.value.toString())
        if (!isSearching.value) {
            viewModelScope.launch {
                _myCourseListState.value = CourseListState.Loading
                loading.value = true
                delay(4000)
                when (val response = authRepo.getMyCourseListResponse()) {
                    is CustomResponse.Success -> {
                        courseList.value = setCourseList(response.data.courseList)
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

    private fun setCourseList(courseItemList: List<CourseItem>): List<CourseItem> {
        return courseItemList.map { courseItem ->
            CourseItem(
                courseId = courseItem.courseId,
                programId = courseItem.programId,
                courseName = courseItem.courseName,
                courseCode = courseItem.courseCode,
                courseNumber = courseItem.courseNumber,
                status = courseItem.status,
                totalSessions = courseItem.totalSessions,
                attendedSessions = courseItem.attendedSessions,
                completedSessions = courseItem.completedSessions,
                staffCompletedSessions = courseItem.staffCompletedSessions,
                year = courseItem.year,
                feedback = courseItem.feedback,
                staffFeedBacks = courseItem.staffFeedBacks,
                sessionType = courseItem.sessionType,
                sessionTopic = courseItem.sessionTopic,
                programName = courseItem.programName,
                institutionCalendarId = courseItem.institutionCalendarId,
                level = courseItem.level,
                courseStatus = setCourseStatus(courseItem),
                endDate = courseItem.endDate,
                startDate = courseItem.startDate,
                rotation = courseItem.rotation,
                rotationCount = courseItem.rotationCount,
                yearNo = courseItem.yearNo,
                levelNo = courseItem.levelNo,
                term = courseItem.term,
                mergedStatus = courseItem.mergedStatus,
                sessions = courseItem.sessions,
                courseSessionDetails = courseItem.courseSessionDetails,
                selectedSessionsInAddDoc = courseItem.selectedSessionsInAddDoc,
            )
        }
    }

    /*   private fun setCourseStaffFeedback(courseStaffFeedback: ArrayList<CourseStaffFeedback?>): ArrayList<CourseStaffFeedback?>? {
           val feedbackList: ArrayList<CourseStaffFeedback?>? = arrayListOf()
           val staffFeedback = courseStaffFeedback.map { feedback ->
               CourseStaffFeedback(
                   _course_id = feedback?._course_id,
                   level_no = feedback?.level_no,
                   year_no = feedback?.year_no,
                   totalFeedback = feedback?.totalFeedback,
                   sessionCompletedCount = feedback?.sessionCompletedCount,
                   sessionCount = feedback?.sessionCount,
                   avgRating = feedback?.avgRating,
                   rotation = feedback?.rotation,
                   rotationCount = feedback?.rotationCount,
                   staffsDetails = feedback?.staffsDetails,
                   subjects = feedback?.subjects?.let { setSubjectModelList(it) }
               )
           }
           feedbackList?.addAll(staffFeedback)
           return feedbackList
       }

       private fun setSubjectModelList(subjectModelList: ArrayList<SubjectModel?>): ArrayList<SubjectModel?>? {
           val subjectList: ArrayList<SubjectModel?> = arrayListOf()
           val subject = subjectModelList.map { subjectModel ->
               SubjectModel(
                   id = subjectModel?.id,
                   subjectId = subjectModel?.subjectId,
                   subjectName = subjectModel?.subjectName,
               )
           }
           subjectList.addAll(subject)
           return subjectList
       }*/

    private fun setCourseStatus(course: CourseItem): Int {
        var coursesStatus = 0
        val completedSessions = getTwoDigit(course.completedSessions ?: 0)
        val totalSessions = getTwoDigit(course.totalSessions ?: 0)

        val currentSystemDate: Date = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        val startDate: String = dateFormat.format(currentSystemDate)
        val endDate = course.endDate
        coursesStatus = if (course.completedSessions!! > 0) {
            if (course.completedSessions == course.totalSessions ||
                (startDate > endDate.toString() && completedSessions.toInt() != 0 && completedSessions.toInt() != totalSessions.toInt())
            ) {
                R.string.completed_txt
            } else {
                R.string.in_progress
            }
        } else {
            val status = if (getAfterDate(course.endDate) == true) {
                0
            } else
                R.string.to_start
            status
        }
        return coursesStatus
    }

    private fun getAcademicYearList() {
        viewModelScope.launch {
            _academicYearListState.value = AcademicYearListState.Loading
            loading.value = true
            when (val response = authRepo.getAcedmicYearResponse()) {
                is CustomResponse.Success -> {
                    academicYearList.value = response.data.dataList
                    loading.value = false
                }
                is CustomResponse.Failure -> {
                    _academicYearListState.value = AcademicYearListState.Failed(response.error)
                }
            }
        }
    }

    fun selectedList(position: Int?): List<CourseItem?> {
        Log.e("position_log", position.toString())
        val filteredList: ArrayList<CourseItem?> = arrayListOf()
        val elements = courseList.value
        Log.e("elements_log", elements.toString())
        for (data in elements) {
            val status = data.courseStatus
            Log.e("status_log", status.toString())
            when (position) {
                0 -> {
                    if (CourseStatus.COMPLETED.value.equals(status)) {
                        filteredList.add(data)
                    }
                }
                1 -> {
                    if (CourseStatus.PENDING.value.equals(status)) {
                        filteredList.add(data)
                    }
                }
                2 -> {
                    if (CourseStatus.ONGOING.value.equals(status)) {
                        filteredList.add(data)
                    }
                }
                else -> {
                    filteredList.addAll(elements)
                    break
                }
            }
        }
        selectCourseItem = filteredList
        return filteredList
    }
}

sealed class MycourseListState {
    object Ideal : MycourseListState()
    object Loading : MycourseListState()
}

data class MycourseViewmodelState(
    val isLoading: Boolean = false,
) {
    fun toUiState(): MycourseListState {
        return when {
            isLoading -> MycourseListState.Loading
            else -> MycourseListState.Ideal
        }
    }
}

enum class CourseStatus(val value: Int) {
    PENDING(R.string.to_start),
    ONGOING(R.string.in_progress),
    COMPLETED(R.string.completed_txt),
}

