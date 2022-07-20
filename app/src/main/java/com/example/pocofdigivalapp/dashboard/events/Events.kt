package com.example.pocofdigivalapp.dashboard.events

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.R
import java.util.*


@Composable
fun ActivityEventItem() {
    val recentChatHeight = (LocalConfiguration.current.screenWidthDp * (2.03f / 2.28f)).dp
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(start = 16.dp)
            .width(recentChatHeight),
        shape = RoundedCornerShape(5.dp),
        backgroundColor = Color.White,
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(
                    horizontal = 10.dp,
                    vertical = 10.dp,
                )
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_ellipse),
                    contentDescription = "active icon"
                )
                Text(
                    text = "In progress • Started 12 mins ago",
                    fontSize = 15.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                )
            }
            Row {
                Text(
                    text = ("Today • 10:00 - 11:00 AM").uppercase(Locale.getDefault()),
                    fontSize = 15.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Onsite",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.hint_text_color),
                )
            }
            Spacer(modifier = Modifier.padding(3.dp))
            Text(
                text = "Quiz one on CNS Module",
                fontSize = 14.sp,
                color = colorResource(id = R.color.text_color),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.padding(3.dp))
            Text(
                text = "Quiz • 10 Questions • L1, L2, P3",
                fontSize = 12.sp,
                color = colorResource(id = R.color.hint_text_color),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Divider(
                color = colorResource(R.color.grey_200),
                thickness = 1.dp,
                modifier = Modifier.padding(top = 15.dp)
            )
            GoToSessionButton(
                color = colorResource(id = R.color.loginBlue),
                onClicked = {},
            )
            Spacer(modifier = Modifier.padding(3.dp))
        }
    }
}

@Composable
fun GoToSessionButton(
    color: Color,
    onClicked: () -> Unit,
) {
    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = color,
        contentColor = color,
    )
    Button(
        colors = mainButtonColor,
        onClick = {
            onClicked()
        },
        modifier = Modifier
            .padding(top = 8.dp, bottom = 6.dp, end = 20.dp, start = 20.dp)
            .height(55.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
    ) {
        Text(
            text = "Go To Session".uppercase(Locale.getDefault()),
            color = colorResource(id = R.color.white),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun ActivityEventItemPreview() {
    ActivityEventItem()
}

@Preview
@Composable
fun EventItemPreview() {
    EventItem()
}

@Composable
fun EventItem() {
    Card(
        modifier = Modifier.padding(5.dp),
        shape = RoundedCornerShape(5.dp),
        backgroundColor = Color.White,
    ) {
        Column(
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_ellipse),
                    contentDescription = "active icon"
                )
                Text(
                    text = "In progress • Started 12 mins ago",
                    fontSize = 15.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Row {
                Text(
                    text = ("Today • 10:00 - 11:00 AM").uppercase(Locale.getDefault()),
                    fontSize = 15.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Onsite",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.hint_text_color),
                )
            }
            Spacer(modifier = Modifier.padding(3.dp))
            Row {
                Image(
                    painter = painterResource(id = R.drawable.merge_type),
                    contentDescription = "merge icon"
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Text(
                    text = "Quiz one on CNS Module",
                    fontSize = 14.sp,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Spacer(modifier = Modifier.padding(3.dp))
            Text(
                text = "Quiz • 10 Questions • L1, L2, P3",
                fontSize = 12.sp,
                color = colorResource(id = R.color.hint_text_color),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Divider(
                color = colorResource(R.color.grey_200),
                thickness = 1.dp,
                modifier = Modifier.padding(top = 15.dp)
            )
            GoToSessionButton(
                color = Color.Black,
                onClicked = {},
            )
        }
    }
}