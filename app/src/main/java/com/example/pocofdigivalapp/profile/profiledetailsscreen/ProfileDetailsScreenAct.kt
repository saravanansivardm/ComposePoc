package com.example.pocofdigivalapp.profile.profiledetailsscreen

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileDetailsScreenAct : ComponentActivity() {
    private val viewModel: ProfileDetailsScreenViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
            ProfileDetailsRoute(viewModel)
        }
    }
}