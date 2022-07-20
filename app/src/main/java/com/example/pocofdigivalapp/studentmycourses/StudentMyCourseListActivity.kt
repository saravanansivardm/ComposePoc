package com.example.pocofdigivalapp.studentmycourses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.androidx.viewmodel.ext.android.viewModel

class StudentMyCourseListActivity : ComponentActivity() {
    private val viewModel: StudentCourseListViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentMyCourseListRoute(viewModel)
//            ShowTextField()
        }
    }
}

@Composable
fun ShowTextField() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        var text by remember { mutableStateOf("Hello") }
        TextField(
            value = text,
            onValueChange = { text = it.trim() },
            label = { Text("Label") }
        )
    }
}
