package com.example.pocofdigivalapp.dashboard.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.pocofdigivalapp.ui.theme.digi_blue


@Composable
fun HomeAppBar(
    onNavigationClick: () -> Unit,
    onNotificationClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.dashboard),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Start,
                fontSize = 22.sp,
            )
        },
        navigationIcon = {
            IconButton(onClick = { onNavigationClick() }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "toggle drawer",
                    tint = Color.White,
                )
            }
        },
        actions = {
            NotificationIcon(
                onNotificationClick
            )
        },
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    )
}

@Preview(showBackground = true)
@Composable
fun HomeAppBarPreview() {
    HomeAppBar(
        onNavigationClick = {},
        onNotificationClick = {},
    )
}

@Preview
@Composable
fun NotificationIconPreview() {
    NotificationIcon(
        onNotificationClick = {}
    )
}

@Composable
fun NotificationIcon(
    onNotificationClick: () -> Unit,
) {
    Row{
        Icon(
            modifier = Modifier
                .width(24.dp)
                .height(24.dp)
                .clickable {
                    onNotificationClick()
                },
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notifications",
            tint = Color.White,
        )
        Text(
            modifier = Modifier
                .offset(x = (-12).dp, y = (-8).dp)
                .background(
                    color = colorResource(id = R.color.red),
                    shape = RoundedCornerShape(50),
                )
                .padding(horizontal = 4.dp),
            text = "2",
            fontSize = 12.sp,
            color = colorResource(id = R.color.white)
        )
    }
}

@Composable
fun DashBoardHomeAppBar() {
    Box(
        modifier = Modifier.height(200.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_lecture),
            contentDescription = "lecture image",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = digi_blue.copy(0.7f)),
            verticalArrangement = Arrangement.Center,
        ) {
            HomeAppBar(
                onNotificationClick = {},
                onNavigationClick = {},
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                DashBoardRating()
            }
            Spacer(modifier = Modifier.padding(20.dp))
        }

    }
}

@Preview
@Composable
fun DashBoardHomeAppBarPreview() {
    DashBoardHomeAppBar()
}