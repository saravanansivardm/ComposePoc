package com.example.pocofdigivalapp.staffverification

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.digivalsolutions.digiclass_v2.ui.document.IndependentViewScreen
import com.example.pocofdigivalapp.document.DocumentItemViewScreen
import com.example.pocofdigivalapp.staffverification.StaffVerificationStatusScreen

class StaffVerificationStatusAct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StaffVerificationStatusScreen()
//            BasicDetailsScreen()
//            DocumentItemViewScreen()
//            IndependentViewScreen()
        }
    }
}
