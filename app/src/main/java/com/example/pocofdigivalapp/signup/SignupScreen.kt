package com.example.pocofdigivalapp.signup

import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.dashboard.NavigationDrawerActivity
import com.example.pocofdigivalapp.forgotpassword.ForgotPasswordAct
import com.example.pocofdigivalapp.utils.showToast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview
@Composable
fun SignupScreenPreview() {
    SignupScreen(
        email = "",
        onEmailChanged = {},
        password = "",
        onPasswordChanged = {},
        onButtonClick = {},
//        onForgotPasswordClick = {},
        requestInProgress = true
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignupScreen(
    email: String,
    onEmailChanged: (String) -> Unit,
    password: String,
    onPasswordChanged: (String) -> Unit,
    onButtonClick: () -> Unit,
//    onForgotPasswordClick: () -> Unit,
    requestInProgress: Boolean,
) {
    val scrollState = rememberScrollState()
    val scaffoldState = rememberScaffoldState()
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        content = {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = painterResource(R.drawable.logo_bg),
                    contentDescription = "background_image",
                    contentScale = ContentScale.FillBounds
                )
            }
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
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = stringResource(id = R.string.app_name),
                    modifier = Modifier
                        .width(220.dp)
                        .padding(top = 106.dp)
                )
                Card(
                    backgroundColor = Color.White,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 20.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top,
                    ) {
                        Text(
                            text = stringResource(R.string.signup),
                            color = colorResource(R.color.dark_grey_color),
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp)
                        )
                        Text(
                            text = stringResource(R.string.email),
                            color = colorResource(R.color.light_grey_colorr),
                            fontSize = 14.sp,
                            textAlign = TextAlign.Start,
                            fontFamily = FontFamily(Font(R.font.roboto_regular)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 26.5.dp)
                        )
                        OutlinedTextField(
                            value = email,
                            onValueChange = {
                                onEmailChanged(it.trim())
                            },
                            placeholder = {
                                Text(
                                    text = stringResource(R.string.enter_email_id),
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
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                                .focusable(true)
                        )
                        Text(
                            text = stringResource(R.string.temporary_password),
                            color = colorResource(R.color.light_grey_colorr),
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_regular)),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 24.dp)
                        )
                        OutlinedTextField(
                            value = password,
                            onValueChange = {
                                onPasswordChanged(it.trim())
                            },
                            placeholder = {
                                Text(
                                    text = stringResource(R.string.enter_password),
                                    color = colorResource(R.color.hint_color),
                                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                    fontSize = 16.sp,
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Password,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = { keyboardController?.hide() }
                            ),
                            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                                    Icon(
                                        imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                        contentDescription = "Password Toggle"
                                    )
                                }
                            },
                            singleLine = true,
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
                                .padding(top = 4.dp)
                                .fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.padding(top = 24.dp))
                        Signup(
                            scaffoldState,
                            focusManager = focusManager,
                            keyboardController = keyboardController,
                            onButtonClick = onButtonClick,
                            email = email,
                            password = password
                        )
                        Divider(
                            color = Color.Gray.copy(0.3f),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 1.dp, end = 1.dp, top = 16.dp)
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = stringResource(R.string.already_have_an_account),
                                color = colorResource(R.color.hint_color),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier.padding(top = 10.dp)
                            )
                            Box(modifier = Modifier.clickable {
//                                onForgotPasswordClick()
                                context.startActivity(
                                    Intent(
                                        context,
                                        ForgotPasswordAct::class.java
                                    )
                                )
                            }) {
                                Text(
                                    text = stringResource(R.string.login),
                                    color = colorResource(R.color.button_color),
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.padding(top = 20.dp, bottom = 28.dp)
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.padding(top = 10.dp))
                if (requestInProgress) CircularProgressIndicator(
                    color = Color.White
                )
            }
        }
    )
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Signup(
    scaffoldState: ScaffoldState,
    focusManager: FocusManager,
    keyboardController: SoftwareKeyboardController?,
    onButtonClick: () -> Unit,
    email: String,
    password: String
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = colorResource(R.color.button_color),
        contentColor = colorResource(R.color.button_color)
    )
    Button(
        colors = mainButtonColor,
        onClick = {
            if (email.isEmpty()) {
                context.showToast(context.getString(R.string.enter_email_id))
            } else if (password.isEmpty()) {
                context.showToast(context.getString(R.string.enter_password))
            } else {
                scope.launch {
                    onButtonClick()
                    context.startActivity(Intent(context, NavigationDrawerActivity::class.java))
                    delay(500)
                    scaffoldState.snackbarHostState.showSnackbar("Email sent successfully!")
                    keyboardController?.hide()
                    focusManager.clearFocus()
                }
            }
        }, modifier = Modifier
            .fillMaxWidth()
            .height(45.dp),
        shape = RoundedCornerShape(6.dp)
    ) {
        Text(
            text = stringResource(R.string.signup),
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily(Font(R.font.roboto_medium)),
        )
    }
}

