package com.example.pocofdigivalapp.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.pocofdigivalapp.R

@Composable
fun CircularProgressBar(
    isDisplayed: Boolean,
) {
    if (isDisplayed) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(20.dp), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularProgressIndicator(
                color = colorResource(R.color.digi_blue)
            )
        }
    }
}