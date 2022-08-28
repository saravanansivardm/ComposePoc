package com.example.pocofdigivalapp

import android.R
import android.content.Intent
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.pocofdigivalapp.mycourse.ProgressIndicator
import com.example.pocofdigivalapp.ui.theme.SplashScreenAndroid12Theme
import com.example.pocofdigivalapp.utils.CircularProgressBar


class SplashScreen : AppCompatActivity() {
    private val viewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }
        setContent {
            SplashScreenAndroid12Theme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    eece()
                }
            }
        }
    }

    private fun eece() {
        val intent = Intent(this, PermissionAct::class.java)
        startActivity(intent)
    }
}