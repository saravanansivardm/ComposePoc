package com.digivalsolutions.digiclass_v2.ui.document

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.StaffVerificationAct
import com.example.pocofdigivalapp.ToolBar
import com.example.pocofdigivalapp.document.DocumentItemScreen


@Preview(showBackground = true)
@Composable
fun IndependentViewScreen() {
    Surface(Modifier.fillMaxSize()) {
        IndependentScreen()
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun IndependentScreen(
) {
    val listItem = listOf(
        "1", "2", "3", "4", "5"
    )
    val scrollState = rememberScrollState()
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(
                state = scrollState,
                orientation = Orientation.Horizontal
            ),
        scaffoldState = scaffoldState,
        backgroundColor = colorResource(R.color.verification_bg),
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    ToolBar(
                        isIconVisible = true,
                        title = stringResource(id = R.string.document),
                    )
                }
                Card(
                    backgroundColor = Color.White,
                    elevation = 5.dp,
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 20.dp,
                            bottom = 64.dp
                        )
                        .fillMaxSize(),
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = stringResource(id = R.string.accepted_formats_with_size),
                            modifier = Modifier.padding(start = 8.dp),
                            color = colorResource(id = R.color.box_text_color),
                            fontSize = 10.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        )

                        LazyColumn {
                            items(
                                items = listItem,
                                itemContent = {
                                    DocumentItemScreen()
                                })
                        }

                    }

                }
            }
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                val submitButtonColor = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.divider_bg),
                    contentColor = colorResource(id = R.color.divider_bg)
                )
                val backButtonColor = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.white),
                    contentColor = colorResource(id = R.color.white)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 8.dp)

                ) {
                    Button(
                        colors = backButtonColor,
                        onClick = {
                        },
                        modifier = Modifier
                            .padding(top = 8.dp, end = 16.dp, start = 16.dp, bottom = 8.dp)
                            .width(162.dp)
                            .height(39.dp),
                        shape = RoundedCornerShape(20.dp),
                        border = BorderStroke(
                            width = 0.5.dp,
                            color = colorResource(id = R.color.digi_blue)
                        )
                    ) {
                        Text(
                            text = stringResource(id = R.string.back),
                            color = colorResource(id = R.color.digi_blue),
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        )
                    }
                    Button(
                        colors = submitButtonColor,
                        onClick = {
                        },
                        modifier = Modifier
                            .padding(top = 8.dp, end = 16.dp, start = 16.dp, bottom = 8.dp)
                            .width(162.dp)
                            .height(39.dp),
                        shape = RoundedCornerShape(20.dp),
                        border = BorderStroke(
                            width = 0.5.dp,
                            color = colorResource(id = R.color.colorGray)
                        )
                    ) {
                        Text(
                            text = stringResource(id = R.string.submit),
                            color = colorResource(id = R.color.grey_color_02),
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        )
                    }
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
    val context = LocalContext.current
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
                    context.startActivity(Intent(context, StaffVerificationAct::class.java))
                },
                modifier = Modifier
                    .width(38.dp)
                    .height(38.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
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