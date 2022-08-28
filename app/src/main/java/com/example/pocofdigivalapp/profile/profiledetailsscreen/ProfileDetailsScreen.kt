package com.example.pocofdigivalapp.profile.profiledetailsscreen


import android.app.DatePickerDialog
import android.content.Context
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarViewMonth
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.ToolBar
import java.util.*


@Preview
@Preview(showBackground = true)
@Composable
fun ProfileDetailsScreenPreview() {
    ProfileDetailsScreen()
}

@Preview
@Preview(showBackground = true)
@Composable
fun CardViewForProfileDetailsPreview() {
    CardViewForProfileDetails()
}

@Composable
fun ProfileDetailsScreen(
) {
    val scrollState = rememberScrollState()
    val scaffoldState = rememberScaffoldState()
    val stepPosition = stringResource(id = R.string.profile_steps, 2, "Profile Details")
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(
                state = scrollState,
                orientation = Orientation.Horizontal
            ),
        scaffoldState = scaffoldState,
        backgroundColor = colorResource(R.color.verification_bg),
        bottomBar = {
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                val nextButtonColor = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.digi_blue),
                    contentColor = colorResource(id = R.color.digi_blue)
                )
                val backButtonColor = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.white),
                    contentColor = colorResource(id = R.color.white)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Button(
                        colors = backButtonColor,
                        onClick = {
                        },
                        modifier = Modifier
                            .padding(top = 8.dp, end = 16.dp, start = 16.dp, bottom = 8.dp)
                            .width(152.dp)
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
                        colors = nextButtonColor,
                        onClick = {
                        },
                        modifier = Modifier
                            .padding(top = 8.dp, end = 16.dp, start = 16.dp, bottom = 8.dp)
                            .width(152.dp)
                            .height(39.dp),
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
                    CardViewForProfileDetails()
                }
            }
        })
}


@Composable
fun CardViewForProfileDetails(
) {
    val focusRequester = remember { FocusRequester() }
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    var expandedNationality by remember { mutableStateOf(false) }
    var expandedCountry by remember { mutableStateOf(false) }
    var expandedDistrict by remember { mutableStateOf(false) }
    var expandedCity by remember { mutableStateOf(false) }
    val suggestions = listOf("Male", "Female")
    var selectedTextNationality by remember { mutableStateOf("") }
    var selectedTextCountry by remember { mutableStateOf("") }
    var selectedTextDistrict by remember { mutableStateOf("") }
    var selectedTextCity by remember { mutableStateOf("") }


    var textFieldSizeNationality by remember { mutableStateOf(Size.Zero) }
    var textFieldSizeCountry by remember { mutableStateOf(Size.Zero) }
    var textFieldSizeDistrict by remember { mutableStateOf(Size.Zero) }
    var textFieldSizeCity by remember { mutableStateOf(Size.Zero) }

    val iconNationality = if (expandedNationality)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    val iconCountry = if (expandedCountry)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    val iconDistrict = if (expandedDistrict)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    val iconCity = if (expandedCity)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.passport_no),
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
                onValueChange = {},
                isError = false,
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.passport_no),
                        color = colorResource(R.color.hint_color),
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontSize = 16.sp,
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Next) }
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
                    .height(55.dp)
                    .focusable(true)
                    .focusRequester(focusRequester)
            )
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
        Column {
            Text(
                text = stringResource(id = R.string.date_of_birth),
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
                onValueChange = {},
                isError = false,
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.date_of_birth),
                        color = colorResource(R.color.hint_color),
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontSize = 16.sp,
                    )
                },
                readOnly = true,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Next) }
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
                    .height(55.dp)
                    .focusable(true)
                    .focusRequester(focusRequester),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.calendar_icon),
                        "contentDescription",
                        Modifier.clickable {
                            showDatePickerDialog(context)
                        })
                }
            )
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
        Column {
            Text(
                text = stringResource(id = R.string.country),
                color = Color.Black.copy(0.5f),
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp, start = 16.dp)
            )
            OutlinedTextField(
                value = selectedTextCountry,
                onValueChange = {
                    Toast.makeText(context, selectedTextCountry, Toast.LENGTH_SHORT).show()
                    selectedTextCountry = it
                },
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
                readOnly = true,
                modifier = Modifier
                    .padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)
                    .fillMaxWidth()
                    .height(55.dp)
                    .onGloballyPositioned { coordinates ->
                        textFieldSizeCountry = coordinates.size.toSize()
                    },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.country),
                        color = colorResource(R.color.hint_color),
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontSize = 16.sp,
                    )
                },
                trailingIcon = {
                    Icon(iconCountry, "contentDescription",
                        Modifier.clickable { expandedCountry = !expandedCountry })
                }
            )
            DropdownMenu(
                expanded = expandedCountry,
                onDismissRequest = { expandedCountry = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { textFieldSizeCountry.width.toDp() })
            ) {
                suggestions.forEach { label ->
                    DropdownMenuItem(onClick = {
                        selectedTextCountry = label
                        expandedCountry = false
                    }) {
                        Text(text = label)
                    }
                }
            }
        }
        Column {
            Text(
                text = stringResource(id = R.string.national_id),
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
                onValueChange = {},
                isError = false,
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.national_id),
                        color = colorResource(R.color.hint_color),
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontSize = 16.sp,
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Next) }
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
                    .height(55.dp)
                    .focusable(true)
                    .focusRequester(focusRequester)
            )
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
        Text(
            text = stringResource(id = R.string.address_details),
            color = Color.Black,
            fontSize = 14.sp,
            textAlign = TextAlign.Start,
            fontFamily = FontFamily(Font(R.font.roboto_bold)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, bottom = 4.dp)
        )
        Column {
            Text(
                text = stringResource(id = R.string.building_no_and_street_name),
                color = Color.Black.copy(0.5f),
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp)
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                isError = false,
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.building_no_and_street_name),
                        color = colorResource(R.color.hint_color),
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontSize = 16.sp,
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Next) }
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
                    .height(55.dp)
                    .focusable(true)
                    .focusRequester(focusRequester)
            )
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
        Column {
            Text(
                text = stringResource(id = R.string.floor_no),
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
                onValueChange = {},
                isError = false,
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.floor_no),
                        color = colorResource(R.color.hint_color),
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontSize = 16.sp,
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Next) }
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
                    .height(55.dp)
                    .focusable(true)
                    .focusRequester(focusRequester)
            )
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
        Column {
            Text(
                text = stringResource(id = R.string.country),
                color = Color.Black.copy(0.5f),
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp, start = 16.dp)
            )
            OutlinedTextField(
                value = selectedTextCountry,
                onValueChange = {
                    selectedTextCountry = it
                },
                isError = false,
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.country),
                        color = colorResource(R.color.hint_color),
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontSize = 16.sp,
                    )
                },
                readOnly = true,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Next) }
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
                    .height(55.dp)
                    .focusable(true)
                    .focusRequester(focusRequester),
                trailingIcon = {
                    Icon(iconCountry, "contentDescription",
                        Modifier.clickable { expandedCountry = !expandedCountry })
                }
            )
            DropdownMenu(
                expanded = expandedCountry,
                onDismissRequest = { expandedCountry = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { textFieldSizeCountry.width.toDp() })
            ) {
                suggestions.forEach { label ->
                    DropdownMenuItem(onClick = {
                        selectedTextCountry = label
                        expandedCountry = false
                    }) {
                        Text(text = label)
                    }
                }
            }
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
        Column {
            Text(
                text = stringResource(id = R.string.district),
                color = Color.Black.copy(0.5f),
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp, start = 16.dp)
            )
            OutlinedTextField(
                value = selectedTextDistrict,
                onValueChange = {
                    selectedTextDistrict = it
                },
                isError = false,
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.district),
                        color = colorResource(R.color.hint_color),
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontSize = 16.sp,
                    )
                },
                readOnly = true,
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Next) }
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
                    .height(55.dp)
                    .focusable(true)
                    .focusRequester(focusRequester),
                trailingIcon = {
                    Icon(iconDistrict, "contentDescription",
                        Modifier.clickable { expandedDistrict = !expandedDistrict })
                }
            )
            DropdownMenu(
                expanded = expandedDistrict,
                onDismissRequest = { expandedDistrict = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { textFieldSizeDistrict.width.toDp() })
            ) {
                suggestions.forEach { label ->
                    DropdownMenuItem(onClick = {
                        selectedTextDistrict = label
                        expandedDistrict = false
                    }) {
                        Text(text = label)
                    }
                }
            }
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
        Column {
            Text(
                text = stringResource(id = R.string.city),
                color = Color.Black.copy(0.5f),
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp, start = 16.dp)
            )
            OutlinedTextField(
                value = selectedTextCity,
                onValueChange = {
                    Toast.makeText(context, selectedTextCity, Toast.LENGTH_SHORT).show()
                    selectedTextCity = it
                },
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
                readOnly = true,
                modifier = Modifier
                    .padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)
                    .fillMaxWidth()
                    .height(55.dp)
                    .onGloballyPositioned { coordinates ->
                        textFieldSizeCity = coordinates.size.toSize()
                    },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.city),
                        color = colorResource(R.color.hint_color),
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontSize = 16.sp,
                    )
                },
                trailingIcon = {
                    Icon(iconCity, "contentDescription",
                        Modifier.clickable { expandedCity = !expandedCity })
                }
            )
            DropdownMenu(
                expanded = expandedCity,
                onDismissRequest = { expandedCity = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { textFieldSizeCity.width.toDp() })
            ) {
                suggestions.forEach { label ->
                    DropdownMenuItem(onClick = {
                        selectedTextCity = label
                        expandedCity = false
                    }) {
                        Text(text = label)
                    }
                }
            }
        }
        Column {
            Text(
                text = stringResource(id = R.string.zipcode),
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
                onValueChange = {},
                isError = false,
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.zipcode),
                        color = colorResource(R.color.hint_color),
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontSize = 16.sp,
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Next) }
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
                    .height(55.dp)
                    .focusable(true)
                    .focusRequester(focusRequester)
            )
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
        Text(
            text = stringResource(id = R.string.other_contact_details),
            color = Color.Black,
            fontSize = 14.sp,
            textAlign = TextAlign.Start,
            fontFamily = FontFamily(Font(R.font.roboto_bold)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, bottom = 4.dp)
        )
        Column {
            Text(
                text = stringResource(id = R.string.office_number),
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
                onValueChange = {},
                isError = false,
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.office_number),
                        color = colorResource(R.color.hint_color),
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontSize = 16.sp,
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Next) }
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
                    .height(55.dp)
                    .focusable(true)
                    .focusRequester(focusRequester)
            )
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
        Column {
            Text(
                text = stringResource(id = R.string.office_extension),
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
                onValueChange = {},
                isError = false,
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.office_extension),
                        color = colorResource(R.color.hint_color),
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontSize = 16.sp,
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Next) }
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
                    .height(55.dp)
                    .focusable(true)
                    .focusRequester(focusRequester)
            )
            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }
        }
    }
}

fun showDatePickerDialog(context: Context) {
    val year: Int
    val month: Int
    val day: Int
    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()
    var date = ""
    val datePickerDialog = DatePickerDialog(
        context, R.style.DialogTheme,
        { _: DatePicker, yearPick: Int, monthPick: Int, dayOfMonth: Int ->
            date = "$dayOfMonth - ${monthPick + 1} - $yearPick"
        }, year, month, day
    )
    datePickerDialog.show()
    Log.e("Selected Date : ", date)
}