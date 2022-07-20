package com.example.pocofdigivalapp.dashboard


import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
import com.example.pocofdigivalapp.ui.theme.GradientOne
import com.example.pocofdigivalapp.ui.theme.GradientTwo

@Preview
@Composable
fun ParallaxEffectPreview() {
    ParallaxEffect(scrollState = ScrollState(1))
}


@Composable
fun ParallaxEffect(scrollState: ScrollState) {
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