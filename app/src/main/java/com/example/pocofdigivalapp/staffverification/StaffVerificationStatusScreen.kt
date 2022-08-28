package com.example.pocofdigivalapp.staffverification

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.pocofdigivalapp.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StaffVerificationStatusScreen() {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier.fillMaxSize().scrollable(
            state = scrollState,
            orientation = Orientation.Vertical
        ),
        backgroundColor = colorResource(R.color.verification_bg),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
        ) {
            ToolBar(
                isIconVisible = false, title = stringResource(id = R.string.staff_verification),
            )
            Card(
                modifier = Modifier
                    .padding(top = 16.dp, end = 16.dp, start = 16.dp)
                    .fillMaxWidth()
                    .height(28.dp),
                shape = RoundedCornerShape(8.dp),
                backgroundColor = colorResource(id = R.color.card_bg),
                elevation = 1.dp
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier = Modifier
                            .padding(start = 12.dp)
                    ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "info",
                        modifier = Modifier
                            .height(16.dp)
                            .width(16.dp),
                        tint = colorResource(R.color.card_txt_color),
                    )}
                    Text(
                        text = stringResource(id = R.string.your_profile_under_review),
                        color = colorResource(R.color.card_txt_color),
                        fontSize = 11.sp,
                        textAlign = TextAlign.Start,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),modifier = Modifier
                            .padding(start = 8.dp)

                    )
                }

            }
            Card(
                modifier = Modifier
                    .padding(top = 8.dp, end = 16.dp, start = 16.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(5.dp),
                backgroundColor = Color.White,
                elevation = 1.dp
            ) {
                Column {
                    Column(
                        modifier = Modifier
                            .padding(top = 24.dp, bottom = 22.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.application_status),
                            color = colorResource(R.color.hint_color),
                            fontSize = 16.sp,
                            textAlign = TextAlign.Start,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            modifier = Modifier
                                .wrapContentHeight()
                                .padding(top = 1.dp, start = 16.dp)
                        )
                        ApplicationStatusFun()
                    }
                }
            }

            Text(
                text = stringResource(id = R.string.overview),
                color = colorResource(id = R.color.box_text_color),
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                modifier = Modifier
                    .padding(top = 24.dp, start = 16.dp)
            )
            OverViewList()

            DocumentScreen()
            /*Card(
                modifier = Modifier
                    .padding(top = 16.dp, end = 16.dp, start = 16.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(4.dp),
                backgroundColor = colorResource(id = R.color.white),
                elevation = 1.dp
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                ) {
                    Text(
                        text = stringResource(id = R.string.biometric),
                        color = colorResource(R.color.box_text_color),
                        fontSize = 14.sp,
                        textAlign = TextAlign.Start,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        modifier = Modifier
                            .wrapContentHeight()
                            .padding(start = 16.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.registration_successful),
                        color = colorResource(R.color.green_color_dark),
                        fontSize = 14.sp,
                        textAlign = TextAlign.Start,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        modifier = Modifier
                            .wrapContentHeight()
                            .padding(top = 8.dp, start = 16.dp)
                    )
                }
            }*/
        }
    }
}

@Composable
fun ApplicationStatusFun() {
    val applicationStatus by remember {
        mutableStateOf(
            listOf(
                "Validation Pending",
                "Validation Pending",
            )
        )
    }
    LazyColumn(
        modifier = Modifier.height(215.dp),
        contentPadding = PaddingValues(start = 4.dp, bottom = 15.dp)
    ) {
        itemsIndexed(applicationStatus) { index, item ->
            ApplicationStatusListItems(value = item, onClick = {}, isSelected = true)
        }
    }

}

@Composable
fun ApplicationStatusListItems(value: String, onClick: () -> Unit, isSelected: Boolean) {
    Column(
        modifier = Modifier
            .padding(top = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.green_circle),
                contentDescription = "merge icon",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .padding(start = 1.dp),
            )
            Text(
                text = stringResource(id = R.string.pending),
                color = colorResource(R.color.dark_orange_color),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                modifier = Modifier
                    .width(60.dp)
                    .height(23.dp)
                    .background(
                        color = colorResource(id = R.color.light_orange_color),
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(top = 1.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier.padding(top = 1.dp, start = 1.dp)
            ) {
                Divider(
                    color = colorResource(R.color.green_color),
                    thickness = 1.dp,
                    modifier = Modifier
                        .width(1.dp)
                        .height(100.dp)
                )
            }
            Column(
                horizontalAlignment = Alignment.Start,
            ) {
                Row(){
                    Text(
                        text = stringResource(id = R.string.validation_pending),
                        color = colorResource(R.color.box_text_color),
                        fontSize = 14.sp,
                        textAlign = TextAlign.Start,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        modifier = Modifier
                            .wrapContentHeight()
                            .padding(top = 5.dp, start = 22.dp)
                    )
                    Box(
                        modifier = Modifier
                            .padding(start = 12.dp,top=8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "info",
                            modifier = Modifier
                                .height(18.dp)
                                .width(18.dp),
                            tint = colorResource(R.color.black),
                        )}
                }
                Text(
                    text = stringResource(id = R.string.till_now),
                    color = colorResource(R.color.light_grey_colorr),
                    fontSize = 13.sp,
                    textAlign = TextAlign.Start,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(top = 5.dp, start = 22.dp)
                )
            }
        }
    }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.grey_circle),
                contentDescription = "circle icon",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .padding(start = 1.dp),
            )
            Text(
                text = stringResource(id = R.string.profile_details_submitted_successfully),
                color = colorResource(R.color.box_text_color),
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                modifier = Modifier
                    .wrapContentHeight()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier.padding(top = 1.dp, start = 1.dp)
            ) {
                Divider(
                    color = colorResource(R.color.divider_bg),
                    thickness = 1.dp,
                    modifier = Modifier
                        .width(1.dp)
                        .height(45.dp)
                )
            }
            Text(
                text = "07/06/2022 - 11:00 AM",
                color = colorResource(R.color.light_grey_colorr),
                fontSize = 13.sp,
                textAlign = TextAlign.Start,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(top = 5.dp, start = 22.dp)
            )
        }
    }
    Box(
        modifier = Modifier.padding(top = 1.dp, start = 18.dp)
    ) {
        Divider(
            color = colorResource(R.color.divider_bg),
            thickness = 1.dp,
            modifier = Modifier
                .width(14.dp)
                .height(1.dp)

        )
    }
}

@Composable
fun OverViewList() {
    val names by remember {
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
    LazyRow(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(start = 15.dp, top = 20.dp, bottom = 15.dp)
    ) {
        itemsIndexed(names) { index, item ->
            OverViewListItems(value = item, onClick = {}, isSelected = true)
        }
    }

}

@Composable
private fun OverViewListItems(
    value: String,
    onClick: () -> Unit,
    isSelected: Boolean,
) {
    val backgroundColor = if (isSelected) Color.White else Color.White.copy(alpha = 0.35f)
    val textColor = if (isSelected) colorResource(id = R.color.tab_selected_color) else Color.Black
    Box(
        modifier = Modifier
            .height(30.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(color = backgroundColor)
            .clickable(enabled = !isSelected, onClick = onClick)
            .padding(horizontal = 15.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = value,
            fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal,
            color = textColor,
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.roboto_medium)),
        )
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
fun StaffVerificationStatusPreview() {
    StaffVerificationStatusScreen()
}
