package com.example.pocofdigivalapp.utils

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource


fun String.isEmailValid(): Boolean {
    return isNotEmpty() && matches(Regex("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}"))
}

fun String.isPasswordValid(): Boolean {
    return length > 1
}

sealed class StringType {
    class Resource(@StringRes val id: Int, vararg val args: Any) : StringType()
    data class Raw(val value: String) : StringType()

    companion object {
        val EMPTY = Raw("")
    }
}



@Composable
fun StringType.getString(): String = when (this) {
    is StringType.Raw -> value
    is StringType.Resource -> stringResource(id = id, *args)
}

fun rawString(text : String) : StringType.Raw{
    return StringType.Raw(text)
}

fun resourceString(@StringRes text: Int) : StringType.Resource {
    return StringType.Resource(text)
}

fun Context.showToast(message: String?, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}
