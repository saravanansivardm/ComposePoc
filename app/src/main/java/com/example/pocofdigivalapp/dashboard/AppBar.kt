package com.example.pocofdigivalapp.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.mycourse.TopBar
import com.example.pocofdigivalapp.ui.theme.GradientOne
import com.example.pocofdigivalapp.ui.theme.GradientTwo
import com.example.pocofdigivalapp.ui.theme.digi_blue

@Preview(showBackground = false)
@Composable
fun AppBarPreview() {
    AppBar(
        onNavigationIconClick = {},
    )
}

@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit
) {
    /*Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(
                Brush.horizontalGradient(
                    listOf(
                        GradientOne, GradientTwo
                    )
                )
            ),
        verticalArrangement = Arrangement.Top,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_bg_dashboard),
                contentDescription = "lecture image",
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent),
                contentScale = ContentScale.FillWidth
            )
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.padding(top = 90.dp, start = 16.dp)
            ) {
                Text(
                    text = "Hello, You have",
                    fontSize = 24.sp,
                    color = Color.White,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "01 Sessions, 05 Activity, 0 Events Today",
                    fontSize = 16.sp,
                    color = Color.White,
                    maxLines = 1,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(2.dp)
                )
            }
        }
    }*/

    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.dashboard),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
        },
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Toggle drawer",
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Notification",
                    tint = Color.White
                )
            }
        },
        elevation = 0.dp,
        backgroundColor = (Color.Transparent).compositeOver(Color.Transparent),
        modifier = Modifier
            .background(
                Brush.horizontalGradient(
                    listOf(
                        GradientOne, GradientTwo
                    )
                )
            ),
    )
}