package com.example.pocofdigivalapp.staffverification

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pocofdigivalapp.staffverification.StaffVerificationStatusScreen

class StaffVerificationStatusAct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StaffVerificationStatusScreen()
        }
    }
}
