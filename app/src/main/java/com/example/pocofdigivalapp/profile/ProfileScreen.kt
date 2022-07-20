package com.example.pocofdigivalapp.profile

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.ToolBar

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(
        onButtonClick = {},
        requestInProgress = true,
    )
}

@Composable
fun ProfileScreen(
    onButtonClick: () -> Unit,
    requestInProgress: Boolean,
) {
    val scrollState = rememberScrollState()
    val stepPosition = stringResource(id = R.string.profile_steps, 1, "Basic Details")
    val courseList: ArrayList<String> = arrayListOf()
    courseList.add("FirstName")
    courseList.add("MiddleName")
    courseList.add("LastName")
    courseList.add("FamilyName")
    courseList.add("Email ID")
    courseList.add("FirstName")
    courseList.add("MiddleName")
    courseList.add("LastName")
    courseList.add("FamilyName")
    courseList.add("Email ID")
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(
                state = scrollState,
                orientation = Orientation.Horizontal
            ),
        backgroundColor = colorResource(R.color.verification_bg),
        bottomBar = {
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                val mainButtonColor = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.digi_blue),
                    contentColor = colorResource(id = R.color.digi_blue)
                )
                Button(
                    colors = mainButtonColor,
                    onClick = {
                        onButtonClick()
                        /*context.startActivity(
                            Intent(
                                context,
                                ProfileScreenAct::class.java
                            )
                        )*/
                    },
                    modifier = Modifier
                        .padding(top = 8.dp, end = 16.dp, start = 16.dp, bottom = 8.dp)
                        .fillMaxWidth()
                        .height(40.dp),
                    shape = RoundedCornerShape(20.dp),
                ) {
                    Text(
                        text = stringResource(id = R.string.next),
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    )
                }
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    ToolBar(
                        isIconVisible = true,
                        title = stringResource(id = R.string.profile),
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .background(colorResource(id = R.color.box_color))
                ) {
                    Text(
                        text = stepPosition,
                        color = colorResource(R.color.box_text_color),
                        fontSize = 14.sp,
                        textAlign = TextAlign.Start,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        modifier = Modifier
                            .wrapContentHeight()
                            .padding(top = 16.dp, start = 16.dp, bottom = 16.dp)
                    )
                }

                Card(
                    backgroundColor = Color.White,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 20.dp,
                            bottom = 114.dp
                        )
                        .fillMaxSize(),
                ) {
                    LazyColumn {
                        itemsIndexed(items = courseList) { _, courseList ->
                            CardViewForProfile(courseList, onclick = {})
                        }
                    }
                }
            }
            //        showDatePicker(context)
        })
}

@Composable
fun CardViewForProfile(courseList: String, onclick: () -> Unit) {
    val focusManager = LocalFocusManager.current
    Text(
        text = courseList,
        color = Color.Black.copy(0.5f),
        fontSize = 14.sp,
        textAlign = TextAlign.Start,
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp, start = 16.dp)
    )
    OutlinedTextField(
        value = "",
        onValueChange = {

        },
        placeholder = {
            Text(
                text = courseList,
                color = colorResource(R.color.hint_color),
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                fontSize = 16.sp,
            )
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            disabledTextColor = Color.Transparent,
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Gray.copy(0.2f),
            unfocusedIndicatorColor = Color.Gray.copy(0.2f),
            disabledIndicatorColor = Color.Transparent,
            cursorColor = colorResource(R.color.button_color),
        ),
        modifier = Modifier
            .padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)
            .fillMaxWidth()
            .height(50.dp)
            .focusable(true)
    )
}
