package com.example.pocofdigivalapp.dashboard.document

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.R


@Composable
fun DocumentView(item: String) {
    Column {
        Row {
            Box(contentAlignment = Alignment.Center) {
                Image(
                    modifier = Modifier
                        .size(24.dp)
                        .padding(start = 8.dp),
                    painter = painterResource(id = R.drawable.ic_user),
                    contentDescription = "file icon"
                )
                Text(
                    text = "Png",
                    fontSize = 5.sp,
                    color = colorResource(id = R.color.hint_text_color),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Spacer(modifier = Modifier.padding(6.dp))
            Text(
                modifier = Modifier.padding(end = 15.dp),
                text = "pptx",
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = "BOT001-Pharmacology",
            fontSize = 12.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 8.dp)
        )
        Divider(
            color = colorResource(R.color.grey_200),
            thickness = 1.dp,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DocumentViewPreview() {
    DocumentView(item = "")
}