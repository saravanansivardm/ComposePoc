package com.example.pocofdigivalapp.utils.ratingBar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class RatingBarConfig {
    var size: Dp = 14.dp
        private set
    var padding: Dp = 2.dp
        private set
    var style: RatingBarStyle = RatingBarStyle.Normal
        private set
    var numStars: Int = 5
        private set
    var isIndicator: Boolean = false
        private set
    var activeColor: Color = Color(0xFFFFC23A)
        private set
    var inactiveColor: Color = Color.LightGray
        private set
    var stepSize: StepSize = StepSize.ONE
        private set
    var hideInactiveStars: Boolean = false
        private set

    fun style(value: RatingBarStyle): RatingBarConfig =
        apply { style = value }
}















