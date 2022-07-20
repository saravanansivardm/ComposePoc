package com.example.pocofdigivalapp.mycourse

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.ui.theme.digi_blue

@Composable
fun CollapsingToolbarBar(
    title: String,
    searchText: String,
    onSearchValueChanged: (String) -> Unit,
    onBackPressed: () -> Unit,
    tabTitles: List<String>,
    onTabSelected: (Int) -> Unit,
    selectedTab: Int,
) {
    Box(
        modifier = Modifier.height(120.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_bg_lecture),
            contentDescription = "lecture image",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = digi_blue.copy(0.7f)),
            verticalArrangement = Arrangement.Top,
        ) {
            TopBar(
                title = title,
                searchText = searchText,
                onSearchValueChanged = onSearchValueChanged,
                onBackPressed = onBackPressed,
            )
            Tab(
                items = tabTitles,
                onItemSelected = onTabSelected,
                selectedItem = selectedTab
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun CollapsingToolbarBarPreview() {
    CollapsingToolbarBar(
        title = "Testing",
        searchText = "Searching",
        onSearchValueChanged = {},
        onBackPressed = {},
        tabTitles = listOf("All", "Starred"),
        onTabSelected = {},
        selectedTab = 1,
    )
}