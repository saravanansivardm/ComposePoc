package com.example.pocofdigivalapp.utils

import android.text.TextUtils
import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun emptyString(): String = ""

fun getTwoDigit(number: Int): String {
    return String.format(
        Locale.ENGLISH,
        "%02d", number
    )
}

fun getCoursesDateFormat(sessionDate: String?): String {
    sessionDate ?: return ""
    try {
        val format = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse(
            getUtcTime(sessionDate)
        )
        date ?: return ""
        val str = format.format(date)
        return (str)
    } catch (e: ParseException) {
        Log.e("DateUtils", "getRemainingTimeFromCurrentTime: ${e.printStackTrace()}")
        e.printStackTrace()
    }
    return ""
}

fun getUtcTime(date: String?): String {
    try {
        date?.let {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
            dateFormat.timeZone = TimeZone.getTimeZone("UTC")
            val utcDate = dateFormat.parse(date)
            utcDate?.let {
                dateFormat.timeZone = TimeZone.getDefault()
                return dateFormat.format(utcDate)
            }
        }
    } catch (exp: java.lang.Exception) {
        Log.e("TAG", "getLocalTime: ", exp)
    }
    return emptyString()
}

fun String?.getYearForSchedule(): String {
    return when {
        ("Year1").equals(this, true) || ("year1").equals(this, true) -> {
            "1st Year"
        }
        ("Year2").equals(this, true) || ("year2").equals(this, true) -> {
            "2nd Year"
        }
        ("Year3").equals(this, true) || ("year3").equals(this, true) -> {
            "3rd Year"
        }
        ("Year4").equals(this, true) || ("year4").equals(this, true) -> {
            "4th Year"
        }
        ("Year5").equals(this, true) || ("year5").equals(this, true) -> {
            "5th Year"
        }
        ("Year6").equals(this, true) || ("year6").equals(this, true) -> {
            "6th Year"
        }
        else -> ""
    }
}

fun String?.capitalizeFirstLetter(): String {
    return if (TextUtils.isEmpty(this)) {
        ""
    } else {
        this?.substring(0, 1)?.toUpperCase(Locale.getDefault()) + this?.substring(1)
            ?.toLowerCase(Locale.getDefault())
    }
}

fun getAfterDate(sessionDate: String?): Boolean? {
    var status = false
    try {
        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse(
            getLocalTime(sessionDate)
        )
        date ?: return null
        val endDate = Calendar.getInstance()
        endDate.time = date
        val currentDate = Calendar.getInstance()
        currentDate.after(endDate).also { status = it }
    } catch (e: ParseException) {
        Log.e("DateUtils", "getRemainingTimeFromCurrentTime: ${e.printStackTrace()}")
        e.printStackTrace()
    }
    return status
}

private fun getLocalTime(date: String?): String {
    try {
        date ?: return ""
        val utcFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        utcFormat.timeZone = TimeZone.getTimeZone("UTC")

        val utcDate = utcFormat.parse(date)
        utcDate ?: return ""
        val pstFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
        pstFormat.timeZone = TimeZone.getDefault()

        return pstFormat.format(utcDate)
    } catch (exp: java.lang.Exception) {
        Log.e("TAG", "getLocalTime: ", exp)
    }
    return ""
}

fun String?.valueOrDefault(default: String = ""): String = this ?: default
fun Int?.valueOrDefault(default: Int = 0): Int = this ?: default
fun Boolean?.valueOrDefault(default: Boolean = false): Boolean = this ?: default

fun getCourseTime(dateString: String?): String {
    dateString ?: return ""
    try {
        val calendar = Calendar.getInstance()
        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse(
            getLocalTime(dateString)
        )
        date?.let {
            val month = SimpleDateFormat("MMM", Locale.getDefault()).format(date)

            calendar.time = date

            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
            val year = calendar.get(Calendar.YEAR)
            return "$month $dayOfMonth, $year"
        }
    } catch (e: ParseException) {
        Log.e("DateUtils", "getRemainingTimeFromCurrentTime: ${e.printStackTrace()}")
        e.printStackTrace()
    }
    return ""
}
