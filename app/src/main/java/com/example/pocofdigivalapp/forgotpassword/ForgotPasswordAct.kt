package com.example.pocofdigivalapp.forgotpassword

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForgotPasswordAct : ComponentActivity() {
    private val viewModel: ForgotPasswordViewModelLatest by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForgotPasswordRoute(viewModel)
        }
    }
}