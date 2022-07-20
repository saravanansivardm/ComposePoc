package com.example.pocofdigivalapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.signup.SignupAct

class StaffVerificationAct : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StaffVerificationScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StaffVerificationScreenPreview() {
    StaffVerificationScreen()
}

@Composable
fun StaffVerificationScreen() {
    val scrollState = rememberScrollState()
    val scaffoldState = rememberScaffoldState()
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = colorResource(R.color.verification_bg),
    ) {
        Column(
            modifier = Modifier
                .scrollable(
                    state = scrollState,
                    orientation = Orientation.Horizontal
                )
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ToolBar(
                isIconVisible = false, title = stringResource(id = R.string.staff_verification),
            )
            Card(
                modifier = Modifier
                    .padding(top = 31.dp, end = 16.dp, start = 16.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(5.dp),
                backgroundColor = Color.White,
                elevation = 1.dp
            ) {
                Column() {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(top = 20.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(26.dp)
                                .background(Color.White),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.Top
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.radiobutton_icon),
                                contentDescription = "merge icon",
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(50.dp)
                                    .padding(start = 1.dp),
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Text(
                                    text = stringResource(id = R.string.profile),
                                    color = colorResource(R.color.digi_blue),
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Start,
                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(top = 1.dp)
                                )
                                /*Text(
                                    text = stringResource(id = R.string.edit),
                                    color = colorResource(R.color.digi_blue),
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Justify,
                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    modifier = Modifier
                                        .padding(top = 1.dp, end = 16.dp)
                                )*/
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 24.dp)
                                .background(Color.White),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.Top
                        ) {
                            Divider(
                                color = colorResource(R.color.divider_bg),
                                thickness = 1.dp,
                                modifier = Modifier
                                    .width(1.dp)
                                    .height(100.dp)
                                    .padding(top = 5.dp)
                            )
                            Column(
                                horizontalAlignment = Alignment.Start,
                            ) {
                                Text(
                                    text = stringResource(id = R.string.add_basic_profile_details_and_vaccination_details),
                                    color = colorResource(R.color.grey_color_02),
                                    fontSize = 13.sp,
                                    textAlign = TextAlign.Start,
                                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(top = 5.dp, start = 22.dp)
                                )
                                val mainButtonColor = ButtonDefaults.buttonColors(
                                    backgroundColor = colorResource(id = R.color.digi_blue),
                                    contentColor = colorResource(id = R.color.digi_blue)
                                )
                                Button(
                                    colors = mainButtonColor,
                                    onClick = {
//                                    onButtonClick()
                                        context.startActivity(
                                            Intent(
                                                context,
                                                ProfileScreenAct::class.java
                                            )
                                        )
                                    },
                                    modifier = Modifier
                                        .padding(top = 8.dp, end = 16.dp, start = 16.dp)
                                        .width(117.dp)
                                        .height(45.dp),
                                    shape = RoundedCornerShape(10.dp),
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.add_details),
                                        color = Color.White,
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    )
                                }
                            }

                        }
                        Spacer(modifier = Modifier.padding(top = 8.dp))
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(32.dp)
                                .background(Color.White),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.Top
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.check_circle_icon),
                                contentDescription = "circle icon",
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(50.dp)
                                    .padding(start = 1.dp),
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Text(
                                    text = stringResource(id = R.string.documents),
                                    color = colorResource(R.color.light_grey_colorr),
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Start,
                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(top = 1.dp, start = 8.dp)
                                )
                                Text(
                                    text = stringResource(id = R.string.edit),
                                    color = colorResource(R.color.digi_blue),
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Justify,
                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    modifier = Modifier
                                        .padding(top = 1.dp, end = 16.dp)
                                )
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 24.dp)
                                .background(Color.White),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.Top
                        ) {
                            Divider(
                                color = colorResource(R.color.divider_bg),
                                thickness = 1.dp,
                                modifier = Modifier
                                    .width(1.dp)
                                    .height(30.dp)
                                    .padding(top = 5.dp)
                            )
                            /*Column(
                                horizontalAlignment = Alignment.Start,
                            ) {
                                Text(
                                    text = stringResource(id = R.string.upload_required_documents),
                                    color = colorResource(R.color.grey_color_02),
                                    fontSize = 13.sp,
                                    textAlign = TextAlign.Start,
                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(top = 5.dp, start = 22.dp)
                                )
                                val mainButtonColor = ButtonDefaults.buttonColors(
                                    backgroundColor = colorResource(id = R.color.digi_blue),
                                    contentColor = colorResource(id = R.color.digi_blue)
                                )
                                Button(
                                    colors = mainButtonColor,
                                    onClick = {
//                                    onButtonClick()
                                    },
                                    modifier = Modifier
                                        .padding(top = 8.dp, end = 16.dp, start = 16.dp)
                                        .width(117.dp)
                                        .height(45.dp),
                                    shape = RoundedCornerShape(10.dp),
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.upload),
                                        color = Color.White,
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    )
                                }
                            }*/

                        }
                        Spacer(modifier = Modifier.padding(top = 8.dp))
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(26.dp)
                                .background(Color.White),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.Top
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.empty_circle),
                                contentDescription = "merge icon",
                                modifier = Modifier
                                    .width(50.dp)
                                    .height(50.dp)
                                    .padding(start = 1.dp),
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Text(
                                    text = stringResource(id = R.string.biometric),
                                    color = colorResource(R.color.light_grey_colorr),
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Start,
                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(top = 1.dp, start = 8.dp)
                                )
                                /*Text(
                                    text = stringResource(id = R.string.edit),
                                    color = colorResource(R.color.digi_blue),
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Justify,
                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    modifier = Modifier
                                        .padding(top = 1.dp, end = 16.dp)
                                )*/
                            }
                        }
                        /*Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 24.dp)
                                .background(Color.White),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.Top
                        ) {
                            Column(
                                horizontalAlignment = Alignment.Start,
                            ) {
                                Text(
                                    text = stringResource(id = R.string.take_biometric_registration),
                                    color = colorResource(R.color.grey_color_02),
                                    fontSize = 13.sp,
                                    textAlign = TextAlign.Start,
                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    modifier = Modifier
                                        .wrapContentHeight()
                                        .padding(top = 5.dp, start = 22.dp)
                                )
                                val mainButtonColor = ButtonDefaults.buttonColors(
                                    backgroundColor = colorResource(id = R.color.digi_blue),
                                    contentColor = colorResource(id = R.color.digi_blue)
                                )
                                Button(
                                    colors = mainButtonColor,
                                    onClick = {
//                                    onButtonClick()
                                    },
                                    modifier = Modifier
                                        .padding(top = 8.dp, end = 16.dp, start = 16.dp)
                                        .width(117.dp)
                                        .height(45.dp),
                                    shape = RoundedCornerShape(10.dp),
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.register),
                                        color = Color.White,
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    )
                                }
                            }

                        }*/
                        Spacer(modifier = Modifier.padding(top = 8.dp, bottom = 20.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.padding(15.dp))
            CircularProgressIndicator(
                color = colorResource(R.color.digi_blue)
            )
        }
    }
}

@Composable
fun ToolBar(
    title: String,
    isIconVisible: Boolean
) {
    val context = LocalContext.current
    Box {
        if (isIconVisible) {
            TopAppBar(
                title = {
                    Text(
                        text = title,
                        color = colorResource(id = R.color.hint_color),
                        textAlign = TextAlign.Start,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    )
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = "Back button",
                        modifier = Modifier
                            .clickable {
                            }
                            .padding(start = 16.dp),
                        tint = colorResource(id = R.color.arrow_color),
                    )
                },
                backgroundColor = Color.White,
                elevation = 0.dp
            )
        } else {
            TopAppBar(
                title = {
                    Text(
                        text = title,
                        color = colorResource(id = R.color.hint_color),
                        textAlign = TextAlign.Start,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        modifier = Modifier.padding(start = 16.dp)
                    )
                },
                backgroundColor = Color.White,
                elevation = 0.dp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToolBarPreview() {
    ToolBar(
        title = stringResource(
            id = R.string.staff_verification
        ),
        isIconVisible = true
    )
}