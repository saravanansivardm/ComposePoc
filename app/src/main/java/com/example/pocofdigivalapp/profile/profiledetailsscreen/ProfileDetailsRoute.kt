package com.example.pocofdigivalapp.profile.profiledetailsscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun ProfileDetailsRoute(
    profileDetailsScreenViewModel: ProfileDetailsScreenViewModel
) {
    val uiState by profileDetailsScreenViewModel.uiState.collectAsState()
    ProfileDetailsScreen()
}