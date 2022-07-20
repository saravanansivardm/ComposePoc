package com.example.pocofdigivalapp.dashboard.activity

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.R
import java.util.*

@Preview(showBackground = true)
@Composable
fun RecentActivityItemViewScreen() {
    RecentActivityItemScreen(item = "")

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RecentActivityItemScreen(
    item: String,
    /*onCloseClicked: () -> Unit,*/
) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
            .wrapContentHeight()
            .background(Color.White, RoundedCornerShape(10.dp)),
    ) {
        Column(
            modifier = Modifier.padding(6.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    IconButton(
                        onClick = {
                            //onCloseClicked()
                        },
                        modifier = Modifier
                            .width(38.dp)
                            .height(38.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_quiz),
                            contentDescription = "merge icon",
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp),
                        )
                    }
                    Column {
                        Text(
                            text = "Quiz one on CNS Module",
                            color = colorResource(id = R.color.digi_class_clr),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(end = 50.dp)
                        )
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .align(Alignment.Center)
                ) {
                    IconButton(
                        onClick = {
                            //onCloseClicked()
                            expanded = true
                        },
                        modifier = Modifier
                            .width(38.dp)
                            .height(38.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_menu),
                            contentDescription = "Back Arrow",
                            modifier = Modifier
                                .width(25.dp)
                                .height(25.dp),
                            tint = Color.Black
                        )
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                        },
                        offset = DpOffset(180.dp, 0.dp),
                    ) {
                        DropdownMenuItem(onClick = { /* Handle refresh! */ }) {
                            Text("Refresh")
                        }
                        Divider()
                        DropdownMenuItem(onClick = { /* Handle settings! */ }) {
                            Text("Settings")
                        }
                        Divider()
                        DropdownMenuItem(onClick = { /* Handle send feedback! */ }) {
                            Text("Send Feedback")
                        }
                    }


                }
            }

            Text(
                text = "Quiz • 10 Questions • L1, L2, P3",
                color = colorResource(id = R.color.hint_text_color),
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(start = 38.dp, end = 16.dp)
                    .align(alignment = Alignment.Start)
            )
            Spacer(modifier = Modifier.padding(top = 1.dp))
            Text(
                text = "Course 1 - Created by Dr.Name",
                color = colorResource(id = R.color.black_54),
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(start = 38.dp, end = 16.dp)
                    .align(alignment = Alignment.Start)
            )
            Spacer(modifier = Modifier.padding(top = 12.dp))
            Divider(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                color = colorResource(id = R.color.black_6), thickness = 0.5.dp
            )
            Spacer(modifier = Modifier.padding(top = 5.dp))
            Text(
                text = "not_scheduled",
                color = colorResource(id = R.color.black_38),
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(start = 38.dp, end = 38.dp)
                    .align(alignment = Alignment.Start)
            )
            Spacer(modifier = Modifier.padding(top = 2.dp))
            Text(
                text = "7 Jan 10:00AM-11:00AM",
                color = colorResource(id = R.color.digi_txt_color),
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(start = 38.dp, end = 38.dp)
                    .align(alignment = Alignment.Start)
            )
            Spacer(modifier = Modifier.padding(top = 2.dp))
            Text(
                text = "93/107 Answered",
                fontSize = 14.sp,
                color = colorResource(id = R.color.digi_txt_color),
                modifier = Modifier
                    .padding(start = 38.dp, end = 38.dp)
                    .align(alignment = Alignment.Start)
            )
            Button(
                //  onButtonClick = onCloseClicked,
                onButtonClick = { },
                title = "VIEW RESULT"
            )
            Divider(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
                color = colorResource(id = R.color.black_6), thickness = 0.5.dp
            )
        }
    }
}

@Composable
fun Button(
    onButtonClick: () -> Unit,
    title: String,
) {
    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = Color.Gray,
        contentColor = Color.Gray
    )
    Button(
        colors = mainButtonColor,
        onClick = {
            onButtonClick()
        },
        modifier = Modifier
            .padding(top = 16.dp, end = 16.dp, start = 16.dp)
            .fillMaxWidth()
            .height(45.dp),
        shape = RoundedCornerShape(5.dp),
    ) {
        Text(
            text = title.uppercase(Locale.getDefault()),
            color = Color.Blue,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

