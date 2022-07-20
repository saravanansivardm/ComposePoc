package com.example.pocofdigivalapp

import com.example.pocofdigivalapp.data.course.CourseListResponse


sealed class NotificationState {
    object Ideal: NotificationState()
    object Loading: NotificationState()
    data class Completed(val courseListResponse: CourseListResponse): NotificationState()
    data class Failed(val message:String): NotificationState()
}