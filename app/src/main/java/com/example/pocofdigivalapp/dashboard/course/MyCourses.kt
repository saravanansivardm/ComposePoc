package com.example.pocofdigivalapp.dashboard.course

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.R

@Composable
fun DashboardMyCoursesCard(
    item: String,
    onclick: () -> Unit,
) {
    Card(
        elevation = 4.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                onclick()
            }
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(
                    horizontal = 10.dp,
                    vertical = 10.dp,
                )
        ) {
            Text(
                text = "BPHYS 203 - Fundamental of Normal body functions",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "Program 1 / Year 2 / Level 3 / Rotation 1",
                fontSize = 14.sp,
                color = colorResource(id = R.color.hint_text_color),
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = "Jan 5, 2021 - Feb 26, 2021",
                fontSize = 14.sp,
                color = colorResource(id = R.color.hint_text_color),
            )
        }
    }
}

@Preview
@Composable
fun DashboardMyCoursesCardPreview() {
    DashboardMyCoursesCard(
        item = "",
        onclick = {}
    )
}