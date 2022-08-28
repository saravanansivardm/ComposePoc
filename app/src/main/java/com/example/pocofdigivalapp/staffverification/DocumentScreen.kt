package com.example.pocofdigivalapp.staffverification

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocofdigivalapp.R

@Preview(showBackground = true)
@Composable
fun DocumentScreenPreview() {
    DocumentScreen()
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DocumentScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize().padding(bottom = 16.dp),
        backgroundColor = colorResource(R.color.verification_bg),
        content = {
            Card(
                modifier = Modifier
                    .padding(top = 16.dp, end = 16.dp, start = 16.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(8.dp),
                elevation = 1.dp
            ) {
                DocumentScreenList()
            }
        }
    )
}

@Composable
fun DocumentScreenList() {
    val names by remember {
        mutableStateOf(
            listOf(
                "Basic Details",
                "Profile Details",
                "Vaccination Details",
                "Documents",
                "Biometric",
            )
        )
    }
    LazyColumn {
        itemsIndexed(names) { index, item ->
            DocumentScreenListItems(value = item, onClick = {}, isSelected = true)
        }
    }

}

@Composable
fun DocumentScreenListItems(value: String, onClick: () -> Unit, isSelected: Boolean) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = "ID Proof",
            color = colorResource(R.color.box_text_color),
            fontSize = 14.sp,
            textAlign = TextAlign.Start,
            fontFamily = FontFamily(Font(R.font.roboto_medium)),
            modifier = Modifier
                .wrapContentHeight()
                .padding(top = 16.dp, start = 16.dp)
        )
    }
    Card(
        backgroundColor = colorResource(id = R.color.card_bg),
        modifier = Modifier
            .padding(end = 16.dp, start = 16.dp, top = 8.dp)
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.resident_national_id),
                color = colorResource(R.color.light_grey_colorr),
                fontSize = 12.sp,
                textAlign = TextAlign.Start,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(top = 8.dp, start = 16.dp)
            )
            Card(
                modifier = Modifier
                    .padding(top = 4.dp, end = 16.dp, start = 16.dp)
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(4.dp),
                backgroundColor = colorResource(id = R.color.grey_box_bg),
                elevation = 1.dp
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier
                            .background(
                                color = colorResource(id = R.color.divider_bg),
                                shape = RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp)
                            ),
                    ) {
                        IconButton(
                            onClick = {
                                //onCloseClicked()
                            },
                            modifier = Modifier
                                .width(52.dp)
                                .height(56.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.pdf_icon),
                                contentDescription = "Back Arrow",
                                tint = colorResource(id = R.color.dark_red)
                            )
                        }
                    }
                    Text(
                        text = "File name123ABC.pdf",
                        color = colorResource(id = R.color.light_grey_colorr),
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(
                            start = 16.dp,
                            end = 50.dp
                        )
                    )
                    IconButton(
                        onClick = {
                            //onCloseClicked()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(start = 16.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.flag_icon),
                            contentDescription = "Back Arrow",
                            tint = colorResource(id = R.color.colorAccent)
                        )
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, end = 18.dp, bottom = 12.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.edit_txt),
                    color = colorResource(R.color.digi_blue),
                    fontSize = 16.sp,
                    textAlign = TextAlign.End,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(top = 8.dp, start = 16.dp)
                )
            }
        }
    }
    Divider(
        color = colorResource(R.color.grey_200),
        thickness = 1.dp,
        modifier = Modifier.padding(top = 8.dp)
    )
}