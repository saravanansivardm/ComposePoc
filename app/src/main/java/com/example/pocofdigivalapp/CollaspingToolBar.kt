package com.example.pocofdigivalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.dashboard.ListMyCourses
import com.example.pocofdigivalapp.dashboard.ListRecentActivities
import com.example.pocofdigivalapp.dashboard.ListRecentChat
import com.example.pocofdigivalapp.dashboard.ListRecentDocuments
import com.example.pocofdigivalapp.ui.theme.GradientOne
import com.example.pocofdigivalapp.ui.theme.GradientTwo

class CollaspingToolBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CollapsingBar()
        }
    }
}

@Composable
fun CollapsingBar() {
    // Creating a Simple Scaffold
    // Layout for the application
    Scaffold(

        // Creating a Top Bar
        topBar = {
            Column(
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
                val lazyListState = rememberLazyListState()
                var scrolledY = 0f
                var previousOffset = 0
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_bg_dashboard),
                        contentDescription = "lecture image",
                        modifier = Modifier
                            .graphicsLayer {
                                scrolledY += lazyListState.firstVisibleItemScrollOffset - previousOffset
                                translationY = scrolledY * 0.5f
                                previousOffset =
                                    lazyListState.firstVisibleItemScrollOffset
                            }
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
            }
        },
        // Creating Content
        content = {
            // Creating a Column Layout
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                // Creating a Scrollable list of 100 items
                val items = (1..1).map { "Item $it" }
                val lazyListState = rememberLazyListState()
                var scrolledY = 0f
                var previousOffset = 0
                LazyColumn(
                    Modifier.fillMaxSize(),
                    lazyListState,
                ) {
                    // Displaying the remaining 100 items
                    items(items) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(colorResource(id = R.color.grey_200))
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                modifier = Modifier.padding(
                                    top = 5.dp,
                                    bottom = 5.dp,
                                    start = 12.dp,
                                    end = 12.dp
                                )
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_chat_black),
                                        contentDescription = "My Courses"
                                    )
                                    Text(
                                        text = stringResource(id = R.string.recent_chats).uppercase(),
                                        modifier = Modifier.padding(start = 6.dp),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = colorResource(id = R.color.digi_txt_color),
                                    )
                                }
                                Text(
                                    text = stringResource(id = R.string.view_all),
                                    textDecoration = TextDecoration.Underline,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    textAlign = TextAlign.End,
                                    color = colorResource(id = R.color.digi_txt_color),
                                    modifier = Modifier.weight(1f)
                                )
                            }
                            ListRecentChat()
                            Row(
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                modifier = Modifier.padding(
                                    top = 5.dp,
                                    bottom = 5.dp,
                                    start = 12.dp,
                                    end = 12.dp
                                )
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_courses_dashboard),
                                        contentDescription = "My Courses"
                                    )
                                    Text(
                                        text = stringResource(id = R.string.my_courses).uppercase(),
                                        modifier = Modifier.padding(start = 6.dp),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = colorResource(id = R.color.digi_txt_color),
                                    )
                                }
                                Text(
                                    text = stringResource(id = R.string.view_all),
                                    textDecoration = TextDecoration.Underline,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    textAlign = TextAlign.End,
                                    color = colorResource(id = R.color.digi_txt_color),
                                    modifier = Modifier.weight(1f)
                                )
                            }
                            ListMyCourses()
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                modifier = Modifier
                                    .padding(
                                        top = 5.dp,
                                        bottom = 5.dp,
                                        start = 12.dp,
                                        end = 12.dp
                                    )
                                    .height(30.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_courses_dashboard),
                                        contentDescription = "chat icon",
                                    )
                                    Text(
                                        text = stringResource(id = R.string.recent_documents).uppercase(),
                                        modifier = Modifier.padding(start = 6.dp),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = colorResource(id = R.color.digi_txt_color),
                                    )
                                }
                                Text(
                                    text = stringResource(id = R.string.view_all),
                                    textDecoration = TextDecoration.Underline,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    textAlign = TextAlign.End,
                                    color = colorResource(id = R.color.digi_txt_color),
                                    modifier = Modifier.weight(1f)
                                )
                            }
                            ListRecentDocuments()
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                modifier = Modifier
                                    .padding(
                                        top = 10.dp,
                                        bottom = 5.dp,
                                        start = 20.dp,
                                        end = 12.dp
                                    )
                                    .height(30.dp)
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Start,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_timeline_dashboard),
                                        contentDescription = "chat icon",
                                    )
                                    Text(
                                        text = stringResource(id = R.string.recent_activities).uppercase(),
                                        modifier = Modifier.padding(start = 6.dp),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        color = colorResource(id = R.color.digi_txt_color),
                                    )
                                }
                                Text(
                                    text = stringResource(id = R.string.view_all),
                                    textDecoration = TextDecoration.Underline,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    textAlign = TextAlign.End,
                                    color = colorResource(id = R.color.digi_txt_color),
                                    modifier = Modifier.weight(1f)
                                )
                            }
                            ListRecentActivities()
                        }
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DashboardChatItemPreview() {
    CollapsingBar()
}