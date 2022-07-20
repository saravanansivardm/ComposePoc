package com.example.pocofdigivalapp.utils

enum class CoursesTabs(val value: String) {

    COMPLETED("Completed"),
    TOSTART("To Start"),
    INPROGRESS("In Progress"),
    ALL("All")
}

fun getAllTabs(): List<CoursesTabs> {
    return listOf(
        CoursesTabs.COMPLETED,
        CoursesTabs.TOSTART,
        CoursesTabs.INPROGRESS,
        CoursesTabs.ALL
    )
}

fun getCourseValue(value: String): CoursesTabs? {
    val map = CoursesTabs.values().associateBy(CoursesTabs::value)
    return map[value]
}
