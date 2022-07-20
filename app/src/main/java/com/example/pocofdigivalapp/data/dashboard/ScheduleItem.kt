package com.example.pocofdigivalapp.data.dashboard

import com.example.pocofdigivalapp.data.sessionlist.MergeSessionData
import com.example.pocofdigivalapp.data.staff.ScheduleStudentsItem
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ScheduleItem {
    @SerializedName("_id")
    val scheduleId: String? = null

    @SerializedName("rotation")
    val rotation: String? = null

    @SerializedName("rotation_count")
    var rotationCount: Int? = null

    @SerializedName("courseType")
    var courseType: String? = null

    @SerializedName("_program_id")
    val programId: String? = null

    @SerializedName("year_no")
    val yearNo: String? = null

    @SerializedName("delivery_symbol")
    val deliverySymbol: String? = null

    @SerializedName("delivery_no")
    val deliveryNo: String? = null

    @SerializedName("_course_id")
    val courseId: String? = null

    @SerializedName("schedule_date")
    val scheduleDate: String? = null

    @SerializedName("program_name")
    val programName: String? = null

    @SerializedName("mode")
    val mode: String? = null

    /*@SerializedName("start")
    val startTime: TimeModel? = null

    @SerializedName("end")
    val endTime: TimeModel? = null

    @SerializedName("subjects")
    val subjects: ArrayList<SubjectModel?>? = null
*/
    @SerializedName("infra_name")
    val infra: String? = null

//    @SerializedName("student_groups")
//    val studentGroups: ArrayList<StudentGroupItem?>? = null

    //Used in schedule list screen
    @SerializedName("isDeleted")
    val isDeleted: Boolean? = null

    @SerializedName("merge_status")
    val mergeStatus: Boolean? = null

    @SerializedName("isActive")
    val isActive: Boolean? = null

    @SerializedName("_institution_id")
    val instId: String? = null

    @SerializedName("_institution_calendar_id")
    val instCalendarId: String? = null

    @SerializedName("type")
    var type: String? = null

    @SerializedName("sessionType")
    var sessionType: String? = null

    @SerializedName("activityId")
    var activityId: String? = null

    @SerializedName("term")
    val term: String? = null

    @SerializedName("_student_group_id")
    val studentGroupId: String? = null

//    @SerializedName("staffs")
//    var staffs: ArrayList<ScheduleStaffItem?>? = null

    @SerializedName("level_no")
    val levelNo: String? = null

    @SerializedName("_infra_id")
    val infraId: Any? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("quizType")
    var quizType: String? = null

    @SerializedName("questionsCount")
    var questionsCount: Int? = null

//    @SerializedName("questions")
//    var question: ArrayList<ActivityQuestion?>? = null

    @SerializedName("socketEventStaffId")
    @Expose
    val socketEventStaffId: String? = null

    @SerializedName("socketEventStudentId")
    @Expose
    val socketEventStudentId: String? = null

    @SerializedName("staffStartWithExam")
    @Expose
    var staffStartWithExam: String? = null

    @SerializedName("setQuizTime")
    @Expose
    var setQuizTime: Long? = null

    @SerializedName("answeredCount")
    @Expose
    var answeredCount: Int? = null

    @SerializedName("totalQuestionCount")
    @Expose
    var totalQuestionCount: Int? = null

    @SerializedName("totalStudentAnsweredCount")
    @Expose
    var totalStudentAnsweredCount: Int? = null

    @SerializedName("totalStudentCount")
    @Expose
    var totalStudentCount: Int? = null

    @SerializedName("createdAt")
    val createdAt: String? = null

    @SerializedName("updatedAt")
    val updatedAt: String? = null

    @SerializedName("__v")
    val version: Int? = null

    @SerializedName("student_count")
    val studentCount: Int? = null

    @SerializedName("status")
    var status: String? = null

//    @SerializedName("session")
//    val session: SessionItem? = null

    @SerializedName("sessionId")
    val sessionId: String? = null

//    @SerializedName("sessionDetail")
//    var sessionDetail: SessionDetailModel? = null

    @SerializedName("absent_count")
    var absentCount: Int? = null

    @SerializedName("students")
    var students: ArrayList<ScheduleStudentsItem?>? = null

    @SerializedName("studentDetails")
    var studentDetails: ScheduleStudentsItem? = null

    @SerializedName("uuid")
    var uuid: String? = null

    @SerializedName("socketPort")
    var socketPort: String? = null

    @SerializedName("_topic_id")
    var topicId: String? = null

    @SerializedName("topic")
    var topic: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("sub_type")
    var subType: String? = null

    @SerializedName("merge_with")
    var mergeWith: ArrayList<MergeSessionData?>? = null

    @SerializedName("isRetake")
    var isRetake: Boolean? = null

    @SerializedName("course_name")
    var courseName: String? = null

//    @SerializedName("schedule")
//    var schedule: ScheduleRequestData? = null

    @SerializedName("start_date")
    var startDate: String? = null

    @SerializedName("end_date")
    var endDate: String? = null

    @SerializedName("scheduleStartDateAndTime")
    var scheduleStartDateAndTime: String? = null

    @SerializedName("scheduleEndDateAndTime")
    var scheduleEndDateAndTime: String? = null

    @SerializedName("zoomDetail")
    val zoomDetail: ZoomDetail? = null

    //Local val
    var isMoreInfoOpen: Boolean = false
    var isMatchFound: Boolean = false
    var shouldShowFeedBackDialog = false
}

data class ZoomDetail(
    @SerializedName("meetingStatus")
    val meetingStatus: String? = null,

    @SerializedName("passCode")
    val passCode: String? = null,

    @SerializedName("zoomMeetingId")
    val zoomMeetingId: String? = null,

    @SerializedName("zoomStartUrl")
    val zoomStartUrl: String? = null,

    @SerializedName("zoomTotalDuration")
    val zoomTotalDuration: Int? = null
)