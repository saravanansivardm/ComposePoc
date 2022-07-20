package com.example.pocofdigivalapp.dashboard.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.utils.ratingBar.CustomRatingBar

@Composable
fun DashBoardRating() {
    val ratingValue = 4.5f
    Row(
        Modifier.padding(5.dp)
    ) {
        Text(
            text = "4/5",
            fontSize = 21.sp,
            color = colorResource(id = R.color.white),
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Column {
            CustomRatingBar(value = ratingValue)
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "No rating received from student",
                fontSize = 12.sp,
                color = colorResource(id = R.color.white),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashBoardRatingPreview() {
    DashBoardRating()
}