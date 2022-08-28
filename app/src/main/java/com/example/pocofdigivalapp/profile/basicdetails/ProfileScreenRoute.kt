package com.example.pocofdigivalapp.profile.basicdetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.pocofdigivalapp.utils.valueOrDefault

@Composable
fun ProfileScreenRoute(
    profileScreenViewModel: ProfileScreenViewModel,
) {
    val uiState by profileScreenViewModel.uiState.collectAsState()
    ProfileScreen(
        isLoading = uiState.isLoading.valueOrDefault(),
        position = uiState.position,
        basicDetailsMap = uiState.basicDetailsMap,
        basicDetailsIsActiveMap = uiState.basicDetailsIsActiveMap,
        onButtonClick = { profileScreenViewModel.onSubmitClicked() },
        onValueEntered = { profileScreenViewModel.onValueEntered(it) }
    )
}