package com.example.pocofdigivalapp.profile.profiledetailsscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ProfileDetailsScreenViewModel : ViewModel() {

    private val viewModelState = MutableStateFlow(
        ProfileDetailsScreenViewModelState(isLoading = false)
    )
    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(viewModelScope, SharingStarted.Eagerly, viewModelState.value.toUiState())



    data class ProfileDetailsScreenViewModelState(
        val isLoading: Boolean? = false,
        val position: Int? = null,
        val basicDetailsMap: MutableMap<String, String> = mutableMapOf(),
        val basicDetailsIsActiveMap: MutableMap<String, String> = mutableMapOf(),
        val lastUpdated: Long = System.currentTimeMillis(),
    ) {
        fun toUiState() =
            ProfileDetailsScreenUiState(
                isLoading = isLoading,
                basicDetailsMap = basicDetailsMap,
                basicDetailsIsActiveMap = basicDetailsIsActiveMap,
                lastUpdated = lastUpdated,
                position = position,
            )
    }


    data class ProfileDetailsScreenUiState(
        val isLoading: Boolean?,
        val basicDetailsMap: MutableMap<String, String>,
        val basicDetailsIsActiveMap: MutableMap<String, String> = mutableMapOf(),
        val lastUpdated: Long,
        val position: Int?,
    )
}