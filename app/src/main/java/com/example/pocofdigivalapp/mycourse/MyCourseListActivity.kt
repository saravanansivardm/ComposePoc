package com.example.pocofdigivalapp.mycourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyCourseListActivity : ComponentActivity() {
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
