package com.example.pocofdigivalapp.utils

import android.content.Context
import androidx.core.content.edit

class PreferenceManager(context: Context) {
    companion object {
        private const val KEY_APP_LANGUAGE = "key.app.language"
        private const val KEY_USER_TOKEN = "key.user.token"
        private const val KEY_FILE_PATH = "key.file.path"
        private const val KEY_IS_FACE_FILE_STORED = "key.face.file.isStored"
        private const val KEY_FACE_FILE_PATH = "key.face.file.path"
        private const val KEY_STUDENT_ID = "key.user.student.id"
        private const val KEY_STUDENT_EMAIL = "key.user.student.email"
        private const val KEY_STUDENT_GENDER = "key.user.student.gender"
        private const val KEY_USER_ID = "key.user.user.id"
        private const val KEY_USER_NAME = "key.user.user.name"
        private const val KEY_MOBILE_NO = "key.user.mobile"
        private const val KEY_USER_LOGGED_IN = "key.user.user.login-status"
        private const val KEY_NOTIFICATION_COUNT = "key.notification.count"
        private const val KEY_ACCESS_TOKEN = "key.access.token"
        private const val KEY_REFRESH_TOKEN = "key.refresh.token"
        private const val KEY_IS_UPDATE_POPUP_SHOWN = "key.is.update.popup.shown"
        private const val KEY_DASHBOARD_EVENT_ID = "key.dashboard.event.id"
        private const val KEY_COURSES_EVENT_ID = "key.courses.event.id"
        private const val KEY_ACTIVITY_EVENT_ID = "key.activity.event.id"
        private const val KEY_CHAT_EVENT_ID = "key.chat.event.id"
        private const val KEY_SESSION_EVENT_ID = "key.session.event.id"
        private const val KEY_LAST_SEEN_NOTIFICATION_COUNT = "key.last.seesn.notification.count"
        private const val KEY_STAFF_INSTITUTION_CALENDAR = "key.user.staff.institutionCalendar"
        private const val KEY_CURRENT_SESSION_TYPE = "key.user.session.type"
        private const val KEY_STREAM_CHAT_TOKEN = "key.stream.chat.token"
        private const val KEY_STUDENT_ACCESS_TOKEN_EXPIRY_TIME = "key.student.access.token.expiry.time"
        private const val KEY_STUDENT_REFRESH_TOKEN_EXPIRY_TIME = "key.student.refresh.token.expiry.time"
        private const val KEY_BASE_URL = "key.base.url"
        private const val KEY_FACE_AUTH_URL = "key.face.auth.url"
        private const val KEY_PDF_URL = "key.pdf.url"
        private const val KEY_SOCKET_URL = "key.socket.url"
        private const val KEY_CHAT_KEY = "key.chat.key"
        private const val KEY_ARABIC_LOCAL = "key.arabic.local"
    }

    fun clearAll() {
        appPreference.edit {
            clear()
        }
    }

    private val appPreference = context.getSharedPreferences("AppData", Context.MODE_PRIVATE)

    fun changeToken(token: String) {
        appPreference.edit { putString(KEY_USER_TOKEN, token) }
    }

    fun getAuthToken(): String? {
        return appPreference.getString(KEY_USER_TOKEN, null)
    }

    fun setPath(path: String) {
        appPreference.edit { putString(KEY_FILE_PATH, path) }
    }

    fun getPath() = appPreference.getString(KEY_FILE_PATH, null)

    fun setIsFaceFileStored(isStored: Boolean, path: String) {
        appPreference.edit {
            putBoolean(KEY_IS_FACE_FILE_STORED, isStored)
            putString(KEY_FACE_FILE_PATH, path)
        }
    }

    fun isFaceFileStored() = appPreference.getBoolean(KEY_IS_FACE_FILE_STORED, false)

    fun setUserLoggedIn(isLoggedIn: Boolean) {
        appPreference.edit {
            putBoolean(KEY_USER_LOGGED_IN, isLoggedIn)
        }
    }

    fun isUserLoggedIn() = appPreference.getBoolean(KEY_USER_LOGGED_IN, false)

    fun getFaceFilePath() = appPreference.getString(KEY_FACE_FILE_PATH, "")

    fun setStudentId(staffId: String?) {
        appPreference.edit {
            putString(KEY_STUDENT_ID, staffId)
        }
    }

    fun getStudentId() = appPreference.getString(KEY_STUDENT_ID, emptyString())

    fun setStudentEmailId(emailId: String?) {
        appPreference.edit {
            putString(KEY_STUDENT_EMAIL, emailId)
        }
    }

    fun getEmailId() = appPreference.getString(KEY_STUDENT_EMAIL, emptyString())

    fun setStudentGender(gender: String?) {
        appPreference.edit {
            putString(KEY_STUDENT_GENDER, gender)
        }
    }

}