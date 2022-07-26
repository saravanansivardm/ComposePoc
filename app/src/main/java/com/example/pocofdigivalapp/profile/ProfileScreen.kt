package com.example.pocofdigivalapp.profile

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.ToolBar
import com.example.pocofdigivalapp.utils.CircularProgressBar
import com.example.pocofdigivalapp.utils.valueOrDefault

@Composable
fun ProfileScreen(
    isLoading: Boolean,
    isError: Boolean,
    basicDetailsMap: MutableMap<String, String>,
    onButtonClick: () -> Unit,
    onValueEntered: (MutableMap<String, String>) -> Unit,
) {
    val scrollState = rememberScrollState()
    val stepPosition = stringResource(id = R.string.profile_steps, 1, "Basic Details")
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
                    val basicDetailKeyList = arrayListOf<String>()
                    basicDetailKeyList.addAll(basicDetailsMap.keys)
//                    AutoFocusingText()
                    LazyColumn {
                        items(items = basicDetailKeyList) { basicDetailKey ->
                            val previousInputValue =
                                basicDetailsMap[basicDetailKey].valueOrDefault()

                            CardViewForProfile(
                                basicDetailKey,
                                previousInputValue,
                                basicDetailsMap,
                                onValueEntered,
                                isError,
                            )
                        }
                    }
                    CircularProgressBar(isDisplayed = isLoading)
                }
            }
        })
}

@Composable
fun AutoFocusingText() {
    val str = "basic"
    var text by remember { mutableStateOf(TextFieldValue(str, selection = TextRange(str.length))) }
    val focusRequester = remember { FocusRequester() }
    OutlinedTextField(
        value = text,
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
        onValueChange = { text = it },
        placeholder = {
            Text(
                text = "basicDetailKey",
                color = colorResource(R.color.hint_color),
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                fontSize = 16.sp,
            )
        },
        modifier = Modifier
            .padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)
            .fillMaxWidth()
            .height(55.dp)
            .focusable(true)
            .focusRequester(focusRequester),
    )
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}


@Composable
fun CardViewForProfile(
    basicDetailKey: String,
    previousInputValue: String,
    basicDetailsMap: MutableMap<String, String>,
    onValueEntered: (MutableMap<String, String>) -> Unit,
    isError: Boolean,
) {
    Log.e("isError_log", isError.toString())
    val focusRequester = remember { FocusRequester() }
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("Male", "Female")
    var selectedText by remember { mutableStateOf("") }

    var textfieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Text(
        text = basicDetailKey,
        color = Color.Black.copy(0.5f),
        fontSize = 14.sp,
        textAlign = TextAlign.Start,
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 6.dp, start = 16.dp)
    )
    if (basicDetailKey == "Gender") {
        OutlinedTextField(
            value = selectedText,
            onValueChange = {
                Toast.makeText(context, selectedText, Toast.LENGTH_SHORT).show()
//                selectedText = it
//                Log.e("selectedText_log", selectedText)
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
            modifier = Modifier
                .padding(top = 4.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)
                .fillMaxWidth()
                .height(55.dp)
                .onGloballyPositioned { coordinates ->
                    textfieldSize = coordinates.size.toSize()
                },
            placeholder = {
                Text(
                    text = basicDetailKey,
                    color = colorResource(R.color.hint_color),
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    fontSize = 16.sp,
                )
            },
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier.clickable { expanded = !expanded })
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedText = label
                    expanded = false
                    basicDetailsMap[basicDetailKey] = selectedText
                    onValueEntered(basicDetailsMap)
                }) {
                    Text(text = label)
                }
            }
        }
    } else {
        OutlinedTextField(
            value = previousInputValue,
            onValueChange = {
                basicDetailsMap[basicDetailKey] = it
//                Log.e("previousInputValue_logg", previousInputValue)
//                Log.e("basicDetailsKey_logg", basicDetailsMap[basicDetailKey].toString())
                onValueEntered(basicDetailsMap)
            },
            isError = isError,
            placeholder = {
                Text(
                    text = basicDetailKey,
                    color = colorResource(R.color.hint_color),
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    fontSize = 16.sp,
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = when (basicDetailKey) {
                    "First Name", "Middle Name", "Last Name" -> KeyboardType.Text
                    "Phone Number" -> KeyboardType.Phone
                    else -> KeyboardType.Email
                },
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