package com.example.pocofdigivalapp.mycourse

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.data.course.CourseItem
import com.example.pocofdigivalapp.utils.*
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CardViewForCourseList(
    courseItem: CourseItem,
    onclick: () -> Unit
) {
    val context = LocalContext.current
    var visible by remember { mutableStateOf(true) }
    val avgRating = courseItem.feedback?.avgRating
    val aa = avgRating?.toFloat() ?: 0.0f

    val totalFeedback = getTwoDigit(courseItem.feedback?.totalFeedback ?: 0)
    val sessionCount = getTwoDigit(courseItem.feedback?.sessionCount ?: 0)
    val completedSessions = getTwoDigit(courseItem.completedSessions ?: 0)
    val totalSessions = getTwoDigit(courseItem.totalSessions ?: 0)

    val currentSystemDate: Date = Calendar.getInstance().time
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val startDate: String = dateFormat.format(currentSystemDate)
    val endDate = courseItem.endDate

    visible =
        startDate > endDate.toString() && completedSessions.toInt() != 0 && completedSessions.toInt() != totalSessions.toInt()

    val rotationCount = courseItem.rotationCount ?: 0
    //For CourseName
    var withRotation = ""
    if (rotationCount > 0) {
        val rotation = stringResource(
            R.string.rotation_count,
            (courseItem.rotationCount ?: 0).toString()
        )
        withRotation = stringResource(
            R.string.three_hypened_string,
            rotation,
            (courseItem.courseCode ?: ""),
            (courseItem.courseName ?: "")
        )
    } else {
        withRotation = stringResource(
            R.string.two_hypened_string,
            (courseItem.courseCode ?: ""),
            (courseItem.courseName ?: "")
        )

    }
    //For CourseYear
    val courseYear = stringResource(
        R.string.course_program_name_rotation,
        (courseItem.programName ?: ""),
        courseItem.year.getYearForSchedule(),
        (courseItem.level ?: ""),
        courseItem.term.capitalizeFirstLetter()
    )
    //For CourseDateTime
    val courseDateTime = stringResource(
        R.string.two_hypened_string,
        getCoursesDateFormat(courseItem.startDate),
        getCoursesDateFormat(courseItem.endDate)
    )
    //For CourseFeedback
    val courseFeedBack = stringResource(
        R.string.feedback_session,
        "" + totalFeedback,
        "" + sessionCount
    )
    //For CompletedCourse
    val completedCourses = stringResource(
        R.string.courses_session_status,
        "" + completedSessions,
        "" + totalSessions
    )
    //For CourseStatus
    val courseStatus = if (courseItem.completedSessions!! > 0) {
        if (courseItem.completedSessions == courseItem.totalSessions || visible) {
            stringResource(R.string.completed_txt)
        } else {
            stringResource(R.string.in_progress)
        }
    } else {
        val str = if (getAfterDate(courseItem.endDate) == true) {
            ""
        } else
            stringResource(R.string.to_start)
        str
    }

    //For Coloring Text
    val courseStatusColor = if (courseStatus == stringResource(R.string.completed_txt)) {
        colorResource(id = R.color.digi_progress_clr)
    } else {
        colorResource(id = R.color.digi_blue)
    }
    Card(
        elevation = 4.dp,
        backgroundColor = colorResource(R.color.white),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(
                top = 10.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 4.dp
            )
            .clickable { }
    ) {
        Row(
            modifier = Modifier
                .padding(start = 16.dp)
        ) {
            Column {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .padding(start = 4.dp, top = 4.dp, end = 12.dp)
                ) {
                    Text(
                        text = withRotation,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.black),
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                Text(
                    text = courseYear,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.hint_text_color),
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = courseDateTime,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.hint_text_color),
                    modifier = Modifier.padding(top = 8.dp)
                )
                Divider(
                    color = colorResource(R.color.grey_200),
                    thickness = 1.dp,
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp, top = 15.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = if (avgRating.isNullOrBlank()) "0.0" else avgRating,
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.digi_txt_color),
                        modifier = Modifier.padding(top = 16.dp),
                        textAlign = TextAlign.Start
                    )
//                    RatingBarValue(aa)
                    RatingBarView(aa)
                }
                Text(
                    text = courseFeedBack,
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.digi_txt_color),
                    modifier = Modifier.padding(top = 8.dp),
                    textAlign = TextAlign.Start
                )
                Divider(
                    color = colorResource(R.color.grey_200),
                    thickness = 1.5.dp,
                    modifier = Modifier.padding(start = 4.dp, end = 16.dp, top = 15.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = completedCourses,
                        fontSize = 14.sp,
                        color = colorResource(id = R.color.digi_txt_color),
                        modifier = Modifier.padding(top = 24.dp)
                    )
                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = if (visible) stringResource(R.string.session_incomplete)
                            else stringResource(R.string.session_incomplete),
                            fontSize = 14.sp,
                            textAlign = TextAlign.End,
                            fontWeight = FontWeight.Medium,
                            color = colorResource(id = R.color.digi_red),
                            modifier = if (visible) Modifier.padding(
                                top = 8.dp,
                                end = 16.dp
                            ) else Modifier
                                .padding(top = 8.dp, end = 16.dp)
                                .alpha(0f),
                        )
                        Text(
                            text = courseStatus,
                            fontSize = 14.sp,
                            color = courseStatusColor,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(top = 4.dp, end = 16.dp),
                            textAlign = TextAlign.End,
                        )
                    }
                }
                val totalSessionsValue = courseItem.totalSessions ?: 0
                val completedSessionsValue = courseItem.completedSessions
//                Log.e("courseStatus_log", courseStatus)
                ProgressIndicator(totalSessionsValue, completedSessionsValue, courseStatus)
            }
        }
    }
}

@Composable
fun ProgressIndicator(totalSessionsValue: Int, completedSessionsValue: Int, courseStatus: String) {

    val progressValue = completedSessionsValue.toDouble() / totalSessionsValue
    val s = "$progressValue" + "f"

    LinearProgressIndicator(
        modifier = Modifier
            .padding(
                start = 4.dp,
                end = 16.dp,
                top = 15.dp,
                bottom = 15.dp
            )
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
            .height(10.dp)
            .fillMaxWidth(),
        //color = colorResource(id = R.color.digi_blue),
//        color = if (completedSessionsValue.toDouble() <= totalSessionsValue)
        color = if (courseStatus.equals(R.string.completed_txt))
            colorResource(R.color.digi_progress_clr) else colorResource(id = R.color.digi_blue),
        backgroundColor = colorResource(R.color.grey_200),
        progress = s.toFloat(),
    )
}
