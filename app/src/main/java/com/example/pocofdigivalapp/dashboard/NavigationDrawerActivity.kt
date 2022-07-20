package com.example.pocofdigivalapp.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.books
import com.example.pocofdigivalapp.dashboard.events.ActivityEventItem
import com.example.pocofdigivalapp.ui.theme.GradientOne
import com.example.pocofdigivalapp.ui.theme.GradientTwo
import com.example.pocofdigivalapp.ui.theme.digi_blue
import kotlinx.coroutines.launch

class NavigationDrawerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            Scaffold(
                scaffoldState = scaffoldState,
                modifier = Modifier
                    .fillMaxSize(),
                topBar = {
                    AppBar(
                        onNavigationIconClick = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }
                    )
                },
                drawerContent = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start
                    ) {
//                        DrawerHeader()
                        DrawerHeaderStudent()
                        Spacer(modifier = Modifier.padding(top = 6.dp))
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "dashboard",
                                    title = stringResource(R.string.dashboard),
                                    contentDescription = "Go to dashboard screen",
                                    icon = ImageVector.vectorResource(id = R.drawable.ic_dashboard),
                                    fontWeight = FontWeight.Normal,
                                    color = colorResource(id = R.color.grey_200)
                                ),
                                MenuItem(
                                    id = "courses",
                                    title = stringResource(R.string.courses),
                                    contentDescription = "Go to courses screen",
                                    icon = ImageVector.vectorResource(id = R.drawable.ic_courses_dashboard_menu),
                                    fontWeight = FontWeight.Normal,
                                    color = colorResource(id = R.color.grey_200)
                                ),
                                MenuItem(
                                    id = "admin courses",
                                    title = stringResource(R.string.course_coordinator),
                                    contentDescription = "Go to admin courses screen",
                                    icon = ImageVector.vectorResource(id = R.drawable.ic_calendar),
                                    fontWeight = FontWeight.Normal,
                                    color = colorResource(id = R.color.grey_200)
                                ),
                                MenuItem(
                                    id = "calendar",
                                    title = stringResource(R.string.calendar),
                                    contentDescription = "Go to calendar screen",
                                    icon = ImageVector.vectorResource(id = R.drawable.ic_calendar),
                                    fontWeight = FontWeight.Normal,
                                    color = colorResource(id = R.color.grey_200)
                                ),
                                MenuItem(
                                    id = "help",
                                    title = "Help",
                                    contentDescription = "Get help",
                                    icon = ImageVector.vectorResource(id = R.drawable.ic_help),
                                    fontWeight = FontWeight.Normal,
                                    color = colorResource(id = R.color.grey_200)
                                ),
                            ),
                            onItemClick = {
                                println("Clicked on ${it.title}")
                            }
                        )
                        Spacer(modifier = Modifier.padding(top = 6.dp))
                        DrawerLanguageBody(items = listOf(), onItemClick = {})
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.padding(top = 6.dp))
                        DrawerLogout()
                    }
                }
            ) {
                Scaffold(
                    content = {
                        Column(
                            Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            val items = (1..1).map { "Item $it" }
                            val lazyListState = rememberLazyListState()
                            var scrolledY = 0f
                            var previousOffset = 0
                            LazyColumn(
                                Modifier.fillMaxSize(),
                                lazyListState,
                            ) {
                                item {
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
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .background(Color.Transparent),
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.ic_bg_dashboard),
                                                contentDescription = null,
                                                contentScale = ContentScale.FillWidth,
                                                modifier = Modifier
                                                    .graphicsLayer {
                                                        scrolledY += lazyListState.firstVisibleItemScrollOffset - previousOffset
                                                        translationY = scrolledY * 1f
                                                        previousOffset =
                                                            lazyListState.firstVisibleItemScrollOffset
                                                    }
                                                    .height(240.dp)
                                                    .fillMaxWidth()
                                            )
                                            Column(
                                                horizontalAlignment = Alignment.Start,
                                                verticalArrangement = Arrangement.SpaceEvenly,
                                                modifier = Modifier.padding(
                                                    top = 75.dp,
                                                    start = 16.dp
                                                )
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
                                }
                                items(items) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(colorResource(id = R.color.grey_200))
                                    ) {
                                        LazyRow(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .offset(y=(-30).dp)
                                        ) {
                                            items(books) { item ->
                                                ActivityEventItem()
                                            }
                                        }
                                        Row(
                                            horizontalArrangement = Arrangement.SpaceEvenly,
                                            modifier = Modifier.padding(
                                                top = 2.dp,
                                                start = 18.dp,
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
                                        Spacer(modifier = Modifier.padding(top = 10.dp))
                                        ListRecentChat()
                                        Row(
                                            horizontalArrangement = Arrangement.SpaceEvenly,
                                            modifier = Modifier.padding(
                                                top = 15.dp,
                                                bottom = 7.dp,
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
                                                    bottom = 10.dp,
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
                                                    painter = painterResource(id = R.drawable.ic_recent_document),
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
                                                    top = 5.dp,
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
                    })
            }
        }
    }
}