package com.example.pocofdigivalapp.staffverification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.R

@Composable
fun BasicDetailsScreen() {
    val infoList by remember {
        mutableStateOf(
            listOf(
                "Basic Details",
                "Profile Details",
                "Vaccination Details",
                "Documents",
                "Biometric",
            )
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(10.dp),
            )
    ) {
        val recentRecentDocumentHeight = (LocalConfiguration.current.screenWidthDp * (2f / 2.63f)).dp
        Box(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                .fillMaxWidth()
                .height(recentRecentDocumentHeight)
                .background(Color.White, RoundedCornerShape(10.dp)),
        ) {
            LazyColumn {
                items(infoList) { overview ->
                    Spacer(modifier = Modifier.padding(8.dp))
                    Column(
                        modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 6.dp, top = 12.dp)
                    ) {
                        Text(
                            text = "Employee ID",
                            color = colorResource(id = R.color.light_grey_colorr),
                            fontSize = 12.sp,
                        )
                        Spacer(modifier = Modifier.padding(2.dp))
                        Text(
                            text = "1234567890",
                            color = colorResource(id = R.color.box_text_color),
                            fontSize = 14.sp,
                        )
                    }
                }
            }
        }
    }
}