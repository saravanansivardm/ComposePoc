package com.example.pocofdigivalapp.studentmycourses

import androidx.compose.foundation.Canvas
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.data.studentmycourse.StudentCourseItem
import com.example.pocofdigivalapp.utils.capitalizeFirstLetter
import com.example.pocofdigivalapp.utils.getAfterDate
import com.example.pocofdigivalapp.utils.getCourseTime
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun StudentCardViewForMyCourseList(
    courseItem: StudentCourseItem,
    onclick: () -> Unit
) {
    var insIdStatus: Boolean
    var presentCount = courseItem.presentCount ?: 0
    var completedSessions = courseItem.completedSessions ?: 0
    val totalSessions = courseItem.totalSessions ?: 0
    if (completedSessions > totalSessions) {
        completedSessions = totalSessions
    }
    if (presentCount > completedSessions) {
        presentCount = completedSessions
    }
    var visible by remember { mutableStateOf(true) }

    val currentSystemDate: Date = Calendar.getInstance().time
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val startDate: String = dateFormat.format(currentSystemDate)
    val endDate = courseItem.endDate

    visible =
        startDate > endDate.toString() && completedSessions != 0 && completedSessions != totalSessions

    var attendancePercent = (presentCount.toFloat() / completedSessions.toFloat()) * 100f
    if (presentCount == 0 || completedSessions == 0) {
        attendancePercent = 0f
    }

    //For AttendancePercent
    val formatter = DecimalFormat()
    formatter.isDecimalSeparatorAlwaysShown = false
    formatter.maximumFractionDigits = 2
    attendancePercent = if (attendancePercent > 100) 100f else attendancePercent
    val percent = formatter.format(attendancePercent)
    val percentValue = if (attendancePercent != 0f && attendancePercent < 10f)
        "0$percent%"
    else if (attendancePercent > 100)
        "100%"
    else
        "$percent%"


    val coursePercent = (completedSessions.toFloat() / totalSessions.toFloat()) * 100f
    //For CourseName
    val rotationCount = courseItem.rotationCount ?: 0
    var withRotation = ""
    if (rotationCount > 0) {
        val rotation = stringResource(
            R.string.rotation_count,
            (courseItem.rotationCount ?: 0).toString()
        )
        withRotation = stringResource(
            R.string.course_name_with_rotation_term,
            rotation,
            (courseItem.courseCode ?: ""),
            (courseItem.courseName ?: ""),
            courseItem.term.capitalizeFirstLetter()
        )
    } else {
        withRotation = stringResource(
            R.string.course_name_with_term,
            (courseItem.courseCode ?: ""),
            (courseItem.courseName ?: ""),
            courseItem.term.capitalizeFirstLetter()
        )

    }
    //For CourseYear
    val courseYear = stringResource(
        R.string.course_level_with_date,
        courseItem.level.capitalizeFirstLetter(),
        getCourseTime(courseItem.startDate),
        getCourseTime(courseItem.endDate),
    )
    //Completed Session
    val completedSession = stringResource(
        R.string.sessions_attended,
        presentCount.toString(),
        completedSessions.toString()
    )
    //Completed Courses
    val completedCourses = stringResource(
        R.string.sessions_completed_and_rating,
        completedSessions.toString(),
        totalSessions.toString()
    )

    val insIdStatusd = if (courseItem.completedSessions!! > 0) {
        stringResource(R.string.completed_txt)
    } else {
        when {
            coursePercent == 100f -> {
                stringResource(R.string.completed_txt)
            }
            coursePercent >= 0f -> {
                stringResource(R.string.in_progress)
            }
            coursePercent == 0f -> {
                stringResource(R.string.to_start)
            }
            else -> ""
        }
    }
    //For AbsentLeaveCount
    val absentLeaveCount = stringResource(
        R.string.absent_leave_count,
        (courseItem.studentLeaveCount ?: 0).toString(),
        (courseItem.studentAbsentCount ?: 0).toString()
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
    val totalSessionsValue = courseItem.totalSessions ?: 0
    val completedSessionsValue = courseItem.completedSessions
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
            .clickable {
                onclick()
            }
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
                Divider(
                    color = colorResource(R.color.grey_200),
                    thickness = 1.dp,
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp, top = 15.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = stringResource(id = R.string.attendance_details),
                            fontSize = 11.sp,
                            color = colorResource(id = R.color.black_87),
                            modifier = Modifier.padding(top = 8.dp),
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Normal,
                        )
                        Spacer(modifier = Modifier.padding(all = 8.dp))
                        CircularProgressIndicator(
                            totalSessionsValue,
                            completedSessionsValue,
                            courseStatus
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 14.dp)
                    ) {
                        Text(
                            text = completedSession,
                            fontSize = 16.sp,
                            color = colorResource(id = R.color.black_87),
                            modifier = Modifier.padding(top = 8.dp),
                            textAlign = TextAlign.Start
                        )

                        Text(
                            text = absentLeaveCount,
                            fontSize = 12.sp,
                            color = colorResource(id = R.color.light_grey_color),
                            modifier = Modifier.padding(top = 8.dp),
                            textAlign = TextAlign.Start
                        )
                    }
                }
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
                ProgressIndicator(totalSessionsValue, completedSessionsValue, courseStatus)
            }
        }
    }
}

@Composable
fun CircularProgressIndicator(
    totalSessionsValue: Int,
    completedSessionsValue: Int,
    courseStatus: String,
    numberStyle: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp
    ),
    size: Dp = 50.dp,
    indicatorThickness: Dp = 3.5.dp,
    foregroundIndicatorColor: Color = colorResource(id = R.color.digi_blue),
    backgroundIndicatorColor: Color = colorResource(id = R.color.grey_200),

    ) {

    val progressValue = completedSessionsValue.toDouble() / totalSessionsValue
    val s = "$progressValue" + "f"
    // It remembers the number value
    val numberR by remember {
        mutableStateOf(11.43f)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size = size)
    ) {
        Canvas(
            modifier = Modifier
                .size(size = size)
        ) {

            // Background circle
            drawCircle(
                color = backgroundIndicatorColor,
                radius = size.toPx() / 2,
                style = Stroke(width = indicatorThickness.toPx(), cap = StrokeCap.Round)
            )

            val sweepAngle = (numberR / 100) * 360

            // Foreground circle
            drawArc(
                color = foregroundIndicatorColor,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(indicatorThickness.toPx(), cap = StrokeCap.Round)
            )
        }
        // Text that shows number inside the circle
        Text(
            text = (numberR).toString(),
            style = numberStyle
        )
    }
//    Spacer(modifier = Modifier.height(32.dp))

}


@Composable
fun ProgressIndicator(
    totalSessionsValue: Int,
    completedSessionsValue: Int,
    courseStatus: String
) {

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
        progress = if (s != "NaNf") s.toFloat() else 0.0.toFloat(),
    )
}
