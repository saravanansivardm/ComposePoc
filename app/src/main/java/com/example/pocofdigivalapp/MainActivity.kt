package com.example.pocofdigivalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pocofdigivalapp.mycourse.CourseListViewModel
import com.example.pocofdigivalapp.mycourse.MycourseListRoute
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel: CourseListViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            viewModel.getMyCourseList()
            val courseList = viewModel.courseList.value
            val academicYearList = viewModel.academicYearList.value
            MycourseListRoute(
                viewModel = viewModel,
                courseList = courseList,
                academicYearList = academicYearList,
            ) {}
        }
    }
}