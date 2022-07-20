package com.example.pocofdigivalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.pocofdigivalapp.dashboard.ListMyCourses
import com.example.pocofdigivalapp.dashboard.ListRecentActivities
import com.example.pocofdigivalapp.dashboard.ListRecentChat
import com.example.pocofdigivalapp.dashboard.ListRecentDocuments

class ConstraintLayouttt : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutDemo()
//            ConstraintLayoutExample()
        }
    }
}

@Composable
fun ConstraintLayoutDemo() {
    Scaffold() {

    }
    BoxWithConstraints {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(colorResource(id = R.color.grey_200))
                .verticalScroll(rememberScrollState())
        ) {
            Column {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .wrapContentHeight(align = Alignment.Top)
                        .padding(2.dp)
                        .background(Color.Red)
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
                                contentDescription = "recent chats"
                            )
                            Text(
                                text = stringResource(id = R.string.recent_chats).uppercase(),
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
                    ListRecentChat()
                }
                Column(
                    modifier = Modifier
                        // fillMaxWidth instead of fillMaxSize
                        .fillMaxWidth()
                        // explicit height modifier
                        .height(150.dp)
                        .wrapContentHeight(align = Alignment.Top)
                        .padding(2.dp)
                        .background(Color.Green)
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
                }
                Column(
                    modifier = Modifier
                        // fillMaxWidth instead of fillMaxSize
                        .fillMaxWidth()
                        // explicit height modifier
                        .height(400.dp)
                        .wrapContentHeight(align = Alignment.Top)
                        .padding(2.dp)
                        .background(Color.Cyan)
                ) {
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
                }
                Column(
                    modifier = Modifier
                        // fillMaxWidth instead of fillMaxSize
                        .fillMaxWidth()
                        // explicit height modifier
                        .height(400.dp)
                        .wrapContentHeight(align = Alignment.Top)
                        .padding(2.dp)
                        .background(Color.Magenta)
                ) {
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
        }
    }
}

@Composable
fun ConstraintLayoutExample() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        val (logo, topBar, companyName) = createRefs()

        // TopAppBar Composable
        TopAppBar(
            modifier = Modifier

                .constrainAs(topBar) {

                    // top of TopAppBar constraints
                    // to top of parent
                    top.linkTo(parent.top)

                    // start of TopAppBar constraints
                    // to start of parent
                    start.linkTo(parent.start)

                    // end of TopAppBar constraints
                    // to end of parent
                    end.linkTo(parent.end)
                },

            backgroundColor = Color.Green
        ) {

            // Contents for topAppBar
            Text(
                text = "Geeks for Geeks | Constraint Layout", color = Color.White
            )
        }

        // Image Composable
        Image(
            // Setting the image saved in drawable
            painter = painterResource(id = R.drawable.ic_ellipse),
            contentDescription = "company logo",
            modifier = Modifier
                .size(70.dp)

                // Pass the reference
                .constrainAs(logo) {

                    // constraint top to bottom of topAppBar
                    top.linkTo(topBar.bottom)

                    // constraint start to parent start
                    start.linkTo(parent.start)

                    // constraint end to parent end
                    end.linkTo(parent.end)

                    // Constraint bottom to top of bottom
                    // text as it will be in bottom most
                    bottom.linkTo(companyName.top)
                })

        // Text Composable
        Text(
            text = "Geeks for geeks",
            color = Color.Black,
            modifier = Modifier.
                // Passing the reference
            constrainAs(companyName) {

                // constraint start to parent start
                start.linkTo(parent.start)

                // constraint end to parent end
                end.linkTo(parent.end)

                // constraint bottom to parent bottom
                bottom.linkTo(logo.bottom)
            })
    }
}
