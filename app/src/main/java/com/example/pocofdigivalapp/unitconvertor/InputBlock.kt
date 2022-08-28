package com.example.pocofdigivalapp.unitconvertor

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputBlock(
    conversion: Conversion,
    inputText: MutableState<String>,
    modifier: Modifier = Modifier,
    calculate: (String) -> Unit,
) {
    val context = LocalContext.current
    Column(modifier.padding(0.dp, 20.dp, 0.dp)) {
        Row(modifier = modifier.fillMaxWidth()) {
            TextField(
                value = inputText.value,
                onValueChange = {
                    inputText.value = it
                },
                modifier = modifier.fillMaxWidth(0.65f),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = true,
                    keyboardType = KeyboardType.Number
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.3F)
                ),
                textStyle = TextStyle(color = Color.DarkGray, fontSize = 30.sp)
            )
            Text(
                text = conversion.convertFrom,
                fontSize = 24.sp,
                modifier = modifier
                    .padding(10.dp, 30.dp, 0.dp, 0.dp)
                    .fillMaxWidth(0.35F)
            )
        }
        Spacer(modifier = Modifier.padding(top = 20.dp))
        OutlinedButton(onClick = {
            if (inputText.value != "") {
                calculate(inputText.value)
            } else {
                Toast.makeText(context, "Please fill details", Toast.LENGTH_SHORT).show()
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Convert",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}