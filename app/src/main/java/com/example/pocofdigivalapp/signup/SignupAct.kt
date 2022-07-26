package com.example.pocofdigivalapp.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.koin.androidx.viewmodel.ext.android.viewModel


class SignupAct : ComponentActivity() {
    private val viewModel: SignUpViewModelLatest by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupRoute(viewModel)
        }
    }
}
