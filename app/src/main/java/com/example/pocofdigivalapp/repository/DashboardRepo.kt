package com.example.pocofdigivalapp.repository


import android.content.Context
import com.example.pocofdigivalapp.api.CustomResponse
import com.example.pocofdigivalapp.data.course.CourseListResponse
import com.example.pocofdigivalapp.data.dashboard.DashboardResponse
import com.example.pocofdigivalapp.data.institutionCalendar.InstitutionCalendarResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DashboardRepo(private val context: Context) {
    fun getDashboardMyCourseResponse(): CustomResponse<CourseListResponse, String> {
        return CustomResponse.Success(
            Gson().fromJson(
                context.assets.open("DashboardMyCourse.json").reader(),
                object : TypeToken<CourseListResponse>() {}.type
            )
        )
    }
}
