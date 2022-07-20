package com.example.pocofdigivalapp.dashboard

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.pocofdigivalapp.R

@Preview(showBackground = true)
@Composable
fun DrawerHeaderStudentPreview() {
    DrawerLanguageBody(
        items = listOf(),
        modifier = Modifier,
        itemTextStyle = TextStyle.Default,
        onItemClick = {}
    )
}

@Composable
fun DrawerHeaderStudent() {
    var visible by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.digi_blue)),
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier,
        ) {
            Row {
                val painter =
                    rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(data = "https://images.unsplash.com/photo-1628373383885-4be0bc0172fa?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1301&q=80")
                            .apply(block = fun ImageRequest.Builder.() {
                                transformations(
                                    CircleCropTransformation(),
                                )
                            }).build()
                    )
                Image(
                    painter = painter, contentDescription = null,
                    modifier = Modifier
                        .width(75.dp)
                        .height(75.dp)
                        .padding(top = 10.dp, start = 2.dp)
                )
                Column {
                    Text(
                        text = "virtualstudent41@mail.com",
                        modifier = Modifier
                            .padding(start = 16.dp, top = 10.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        overflow = TextOverflow.Ellipsis,
                        color = colorResource(id = R.color.white),
                    )
                    Text(
                        text = "0987654321",
                        modifier = Modifier
                            .padding(start = 16.dp, top = 6.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.white),
                    )
                }
                val context = LocalContext.current
                IconButton(onClick = {
                    visible = !visible
                }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_down),
                        contentDescription = "toggle drawer",
                        tint = Color.White,
                    )
                }
            }
            Spacer(modifier = Modifier.padding(bottom = 6.dp))
            if (visible) {
                Column {
                    Text(
                        text = stringResource(id = R.string.enrolled_program),
                        modifier = Modifier
                            .padding(start = 16.dp, top = 6.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.white),
                    )
                    Text(
                        text = "-kkkk",
                        modifier = Modifier
                            .padding(start = 16.dp, top = 6.dp, bottom = 10.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.white),
                    )
                    Text(
                        text = stringResource(id = R.string.enrolled_term),
                        modifier = Modifier
                            .padding(start = 16.dp, top = 6.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.white),
                    )
                    Text(
                        text = "Regular",
                        modifier = Modifier
                            .padding(start = 16.dp, top = 6.dp, bottom = 10.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.white),
                    )
                    Text(
                        text = stringResource(id = R.string.enrolled_date),
                        modifier = Modifier
                            .padding(start = 16.dp, top = 6.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.white),
                    )
                    Text(
                        text = "11/10/2021",
                        modifier = Modifier
                            .padding(start = 16.dp, top = 6.dp, bottom = 10.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.white),
                    )
                    Text(
                        text = stringResource(id = R.string.email),
                        modifier = Modifier
                            .padding(start = 16.dp, top = 6.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.white),
                    )
                    Text(
                        text = "virtualstudent41@ibnsina.edu.sa",
                        modifier = Modifier
                            .padding(start = 16.dp, top = 6.dp, bottom = 10.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.white),
                    )
                }
            }
        }
    }
}

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .background(colorResource(id = R.color.digi_blue)),
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        ) {
            val painter =
                rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = "https://images.unsplash.com/photo-1628373383885-4be0bc0172fa?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1301&q=80")
                        .apply(block = fun ImageRequest.Builder.() {
                            transformations(
                                CircleCropTransformation(),
                            )
                        }).build()
                )
            Image(
                painter = painter, contentDescription = null,
                modifier = Modifier
                    .width(65.dp)
                    .height(65.dp)
                    .padding(top = 10.dp, start = 18.dp)
            )
            Text(
                text = stringResource(id = R.string.name),
                modifier = Modifier
                    .padding(start = 16.dp, top = 10.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white),
            )
            Text(
                text = "Noor khan",
                modifier = Modifier
                    .padding(start = 16.dp, top = 6.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.white),
            )
            Text(
                text = stringResource(id = R.string.employee_id),
                modifier = Modifier
                    .padding(start = 16.dp, top = 6.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white),
            )
            Text(
                text = "D0003",
                modifier = Modifier
                    .padding(start = 16.dp, top = 6.dp, bottom = 10.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.white),
            )
        }
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn(modifier) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.contentDescription,
                    modifier = Modifier
                        .height(25.dp)
                        .width(25.dp),
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = R.color.hint_text_color)
                )
            }
        }
    }
}

@Composable
fun DrawerLanguageBody(
    items: List<MenuItem>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn(modifier) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.contentDescription,
                    modifier = Modifier
                        .height(25.dp)
                        .width(25.dp),
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(id = R.color.hint_text_color)
                )
            }
        }
    }
}

@Composable
fun DrawerLogout(
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 40.dp, end = 40.dp)
                .background(Color.Black, shape = RoundedCornerShape(20.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sign out",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.white),
                textAlign = TextAlign.Center
            )
        }

        Text(
            text = "2.7.18-staging",
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.black),
            modifier = Modifier.padding(start = 10.dp, end = 10.dp)
        )
    }
}