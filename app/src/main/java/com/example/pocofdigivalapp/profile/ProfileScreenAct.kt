package com.example.pocofdigivalapp.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileScreenAct : ComponentActivity() {
    private val viewModel: ProfileScreenViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreenRoute(viewModel)
        }
    }
}
