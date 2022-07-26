package com.example.pocofdigivalapp.repository


import android.content.Context
import com.example.notificationactcompose.data.studentinstitutionCalendar.StudentInstitutionCalendarResponse
import com.example.pocofdigivalapp.api.CustomResponse
import com.example.pocofdigivalapp.data.basicdetailupdate.BasicDetailsUpdateResponse
import com.example.pocofdigivalapp.data.course.CourseListResponse
import com.example.pocofdigivalapp.data.forgotpassword.ForgotPasswordResponse
import com.example.pocofdigivalapp.data.institutionCalendar.InstitutionCalendarResponse
import com.example.pocofdigivalapp.data.profileinfoupdate.ProfileInfoUpdateResponse
import com.example.pocofdigivalapp.data.signup.SignupResponse
import com.example.pocofdigivalapp.data.studentmycourse.StudentCourseListResponse
import com.example.pocofdigivalapp.data.userdetailsget.UserDetailsGetResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AuthRepo(private val context: Context) {

    fun getMyCourseListResponse(): CustomResponse<CourseListResponse, String> {
        return CustomResponse.Success(
            Gson().fromJson(
                context.assets.open("MyCourse.json").reader(),
                object : TypeToken<CourseListResponse>() {}.type
            )
        )
    }

    fun getAcedmicYearResponse(): CustomResponse<InstitutionCalendarResponse, String> {
        return CustomResponse.Success(
            Gson().fromJson(
                context.assets.open("InstitutionCalendar.json").reader(),
                object : TypeToken<InstitutionCalendarResponse>() {}.type
            )
        )
    }

    fun getStudentMyCourseListResponse(): CustomResponse<StudentCourseListResponse, String> {
        return CustomResponse.Success(
            Gson().fromJson(
                context.assets.open("StudentMyCourse.json").reader(),
                object : TypeToken<StudentCourseListResponse>() {}.type
            )
        )
    }

    fun getStudentAcademicYearResponse(): CustomResponse<StudentInstitutionCalendarResponse, String> {
        return CustomResponse.Success(
            Gson().fromJson(
                context.assets.open("StudentInstitutionCalendar.json").reader(),
                object : TypeToken<StudentInstitutionCalendarResponse>() {}.type
            )
        )
    }

    fun getSignUp(): CustomResponse<SignupResponse, String> {
        return CustomResponse.Success(
            Gson().fromJson(
                context.assets.open("UserSignup.json").reader(),
                object : TypeToken<SignupResponse>() {}.type
            )
        )
    }

    fun getForgotPassword(): CustomResponse<ForgotPasswordResponse, String> {
        return CustomResponse.Success(
            Gson().fromJson(
                context.assets.open("ForgotPasswordResponse.json").reader(),
                object : TypeToken<ForgotPasswordResponse>() {}.type
            )
        )
    }

    fun getUserDetails(): CustomResponse<UserDetailsGetResponse, String> {
        return CustomResponse.Success(
            Gson().fromJson(
                context.assets.open("UserDetailsGet.json").reader(),
                object : TypeToken<UserDetailsGetResponse>() {}.type
            )
        )
    }

    fun getBasicDetailUpdate(basicDetailscredentials: Any?): CustomResponse<BasicDetailsUpdateResponse, String> {
        return CustomResponse.Success(
            Gson().fromJson(
                context.assets.open("BasicDetailUpdate.json").reader(),
                object : TypeToken<BasicDetailsUpdateResponse>() {}.type
            )
        )
    }

    fun getProfileInfoUpdate(): CustomResponse<ProfileInfoUpdateResponse, String> {
        return CustomResponse.Success(
            Gson().fromJson(
                context.assets.open("ProfileInfoUpdate.json").reader(),
                object : TypeToken<ProfileInfoUpdateResponse>() {}.type
            )
        )
    }
}
