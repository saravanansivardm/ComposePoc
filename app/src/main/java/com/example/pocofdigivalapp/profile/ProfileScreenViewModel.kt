package com.example.pocofdigivalapp.profile

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocofdigivalapp.CourseListState
import com.example.pocofdigivalapp.data.course.CourseItem
import com.example.pocofdigivalapp.signup.LoginViewModelState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ProfileScreenViewModel() : ViewModel() {
    private val viewModelState = MutableStateFlow(
        LoginViewModelState(isLoading = false)
    )
    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(viewModelScope, SharingStarted.Eagerly, viewModelState.value.toUiState())

    private val _myCourseListState: MutableState<CourseListState> = mutableStateOf(CourseListState.Loading)
    val courseList: MutableState<List<CourseItem>> = mutableStateOf(ArrayList())

    fun onSubmitClicked() {
        Log.e("onSubmitClicked_log", "true")
    }
}

sealed class ProfileState {
    object Ideal : ProfileState()
    object Loading : ProfileState()
}

data class LoginViewModelState(
    val isLoading: Boolean = false,
    val isLogoClicked: Boolean = false,
) {
    fun toUiState(): ProfileState {
        return when {
            isLoading -> ProfileState.Loading
            else -> ProfileState.Ideal
        }
    }
}