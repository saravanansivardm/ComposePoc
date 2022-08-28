package com.example.pocofdigivalapp

import com.example.pocofdigivalapp.data.course.CourseItem
import com.example.pocofdigivalapp.data.institutionCalendar.InstitutionCalendarList

sealed class CourseListState {
    object Ideal : CourseListState()
    object Loading : CourseListState()
    data class Completed(val courseListResponse: ArrayList<CourseItem?>?) : CourseListState()
    data class Failed(val message: String) : CourseListState()
}

sealed class AcademicYearListState {
    object Ideal : AcademicYearListState()
    object Loading : AcademicYearListState()
    data class Completed(val academicyearListResponse: ArrayList<InstitutionCalendarList?>?) :
        AcademicYearListState()

    data class Failed(val message: String) : AcademicYearListState()
}