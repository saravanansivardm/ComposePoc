package com.example.pocofdigivalapp.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.dashboard.activity.RecentActivityItemScreen
import com.example.pocofdigivalapp.dashboard.chat.DashboardChatItem
import com.example.pocofdigivalapp.dashboard.course.DashboardMyCoursesCard
import com.example.pocofdigivalapp.dashboard.document.DocumentView
import com.example.pocofdigivalapp.dashboard.events.ActivityEventItem

@Composable
fun DashboardList() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = colorResource(R.color.light_grey_color),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorResource(id = R.color.grey_200)),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.padding(
                        top = 10.dp,
                        bottom = 10.dp,
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
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.digi_txt_color),
                        )
                    }
                    Text(
                        text = stringResource(id = R.string.view_all),
                        textDecoration = TextDecoration.Underline,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
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
                            top = 10.dp,
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
                            painter = painterResource(id = R.drawable.ic_courses_dashboard),
                            contentDescription = "chat icon",
                        )
                        Text(
                            text = stringResource(id = R.string.recent_documents).uppercase(),
                            modifier = Modifier.padding(start = 6.dp),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.digi_txt_color),
                        )
                    }
                    Text(
                        text = stringResource(id = R.string.view_all),
                        textDecoration = TextDecoration.Underline,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
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
                            painter = painterResource(id = R.drawable.ic_timeline_dashboard),
                            contentDescription = "chat icon",
                        )
                        Text(
                            text = stringResource(id = R.string.recent_activities).uppercase(),
                            modifier = Modifier.padding(start = 6.dp),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.digi_txt_color),
                        )
                    }
                    Text(
                        text = stringResource(id = R.string.view_all),
                        textDecoration = TextDecoration.Underline,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End,
                        color = colorResource(id = R.color.digi_txt_color),
                        modifier = Modifier.weight(1f)
                    )
                }
                ListRecentActivities()
            }
        }
    )
}
@Composable
fun CurrentEventsList() {
    val recentMyCourseHeight = (LocalConfiguration.current.screenWidthDp * (0.5f / 1f)).dp
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .height(recentMyCourseHeight)
    ) {
        val myCourses = mutableListOf<String>()
        for (i in 1..5) myCourses += " #$i"
        LazyRow {
            items(items = myCourses, itemContent = { item ->
                ActivityEventItem()
            })
        }
    }
}
@Composable
fun ListRecentChat() {
    val recentChatHeight = (LocalConfiguration.current.screenWidthDp * (2f / 2.28f)).dp
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .height(recentChatHeight)
            .background(Color.White, RoundedCornerShape(10.dp)),
    ) {
        val recentChat = mutableListOf<String>()
        for (i in 1..5) recentChat += "Test #$i"
        LazyColumn {
            items(items = recentChat, itemContent = { item ->
                DashboardChatItem(item, onclick = {})
            })
        }
    }
}

@Composable
fun ListMyCourses() {
    val recentMyCourseHeight = (LocalConfiguration.current.screenWidthDp * (1f / 3.5f)).dp
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(recentMyCourseHeight)
    ) {
        val myCourses = mutableListOf<String>()
        for (i in 1..5) myCourses += "Test #$i"
        LazyRow {
            items(items = myCourses, itemContent = { item ->
                DashboardMyCoursesCard(item, onclick = {})
            })
        }
    }
}

@Composable
fun ListRecentDocuments() {
    val recentRecentDocumentHeight = (LocalConfiguration.current.screenWidthDp * (2f / 2.63f)).dp
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            .height(recentRecentDocumentHeight)
            .background(Color.White, RoundedCornerShape(10.dp)),
    ) {
        val recentDocument = mutableListOf<String>()
        for (i in 1..5) recentDocument += "Test #$i"
        LazyColumn {
            items(items = recentDocument, itemContent = { item ->
                DocumentView(item)
            })
        }
    }
}

@Composable
fun ListRecentActivities() {
    val recentRecentActivityHeight =
        (LocalConfiguration.current.screenHeightDp * (2.63f / 1.56f)).dp
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp, top = 1.dp, bottom = 8.dp)
            .height(recentRecentActivityHeight)
    ) {
        val recentAct = mutableListOf<String>()
        for (i in 1..5) recentAct += "Test #$i"
        LazyColumn {
            items(items = recentAct, itemContent = { item ->
                RecentActivityItemScreen(item)
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ListMyCoursesScreenPreview() {
    CurrentEventsList()
}

/*@Preview(showBackground = true)
@Composable
private fun ListRecentDocumentsScreenPreview() {

}*/

/*
@Preview(showBackground = true)
@Composable
private fun ListRecentActivitiesScreenPreview() {

}*/
