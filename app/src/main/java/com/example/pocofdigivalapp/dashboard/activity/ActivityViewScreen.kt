package com.example.pocofdigivalapp.dashboard.activity

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.R

@Preview(showBackground = true)
@Composable
fun ActivityViewScreen() {
    Surface(Modifier.fillMaxSize()) {
        ActivityScreen(
        )
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ActivityScreen() {
    val listItem = listOf(
        "1", "2","3","4","5"
    )
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = colorResource(R.color.white),
        content = {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CalenderToolbar(
                    title ="Title",
                    onCloseClicked = {},
                )
                Spacer(modifier = Modifier.padding(top = 16.dp))
                Text(
                    text = "Lecture 03 - Course Name",
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .align(alignment = Alignment.Start)
                )
                LazyColumn {
                    items(
                        items = listItem,
                        itemContent = {
//                            RecentActivityItemScreen()
                        })
                }
            }
        }
    )
}


@Composable
fun CalenderToolbar(
    title: String,
    onCloseClicked: () -> Unit,
) {
    Box {
        TopAppBar(
            contentPadding = PaddingValues(),
            backgroundColor = Color.White,
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        Color.White
                    )
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .background(color = Color.White)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = title,
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 16.dp)
        ) {
            IconButton(
                onClick = {
                    //onCloseClicked()
                },
                modifier = Modifier
                    .width(38.dp)
                    .height(38.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Close,
                    contentDescription = "Back Arrow",
                    modifier = Modifier
                        .width(25.dp)
                        .height(25.dp),
                    tint = Color.Black
                )
            }
        }
    }
}
