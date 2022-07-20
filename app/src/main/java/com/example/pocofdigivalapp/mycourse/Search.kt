package com.example.pocofdigivalapp.mycourse

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.R

@Preview(showBackground = false)
@Composable
fun TopBarPreview() {
    TopBar(
        title = "Recent Documents",
        searchText = "",
        onSearchValueChanged = {},
        onBackPressed = {},
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TopBar(
    title: String,
    searchText: String,
    onSearchValueChanged: (String) -> Unit,
    onBackPressed: () -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var isSearch by remember { mutableStateOf(false) }
    TopAppBar(
        title = {
            if (isSearch) {
                SearchBar(
                    searchText,
                    onSearchValueChanged,
                    keyboardController,
                )
            } else {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Start,
                    fontSize = 24.sp,
                )
            }
        },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = "Back button",
                modifier = Modifier.clickable {
                    if (isSearch) {
                        isSearch = false
                        keyboardController?.hide()
                        onSearchValueChanged("")
                    } else {
                        onBackPressed()
                    }
                },
                tint = Color.White
            )
        },
        actions = {
            if (!isSearch) {
                Image(
                    painter = painterResource(id = R.drawable.ic_course_search),
                    contentDescription = "Search",
                    modifier = Modifier
                        .clickable {
                            isSearch = true
                        }
                )
            }
        },
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
    value: String,
    onValueChanged: (String) -> Unit,
    keyboardController: SoftwareKeyboardController?,
) {
    TextField(
        value = value,
        onValueChange = {
            onValueChanged(it.trim())
        },
        placeholder = {
            Text(
                text = stringResource(R.string.search),
                color = Color.White
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { keyboardController?.hide() }
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                tint = Color.White
            )
        },

        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            disabledTextColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.White,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = colorResource(id = R.color.white),
        ),
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .focusable(true)
    )
}