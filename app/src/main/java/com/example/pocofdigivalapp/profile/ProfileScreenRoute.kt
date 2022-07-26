package com.example.pocofdigivalapp.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.pocofdigivalapp.data.userdetailsget.BasicDetail
import com.example.pocofdigivalapp.utils.valueOrDefault

@Composable
fun ProfileScreenRoute(
    profileScreenViewModel: ProfileScreenViewModel,
) {
    val uiState by profileScreenViewModel.uiState.collectAsState()
    ProfileScreen(
        isLoading = uiState.isLoading.valueOrDefault(),
        isError = uiState.isError.valueOrDefault(),
        basicDetailsMap = uiState.basicDetailsMap,
        onButtonClick = { profileScreenViewModel.onSubmitClicked() },
        onValueEntered = {profileScreenViewModel.onValueEntered(it)}
    )
}