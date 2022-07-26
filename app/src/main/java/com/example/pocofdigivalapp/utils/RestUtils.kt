package com.example.pocofdigivalapp.utils

import android.accounts.NetworkErrorException
import android.content.res.AssetManager
import android.text.TextUtils
import android.util.Log
import com.example.pocofdigivalapp.R
import com.example.pocofdigivalapp.data.ApiResponse
import com.example.pocofdigivalapp.data.CommonApiError
import com.example.pocofdigivalapp.repository.ApiFailure
import com.example.pocofdigivalapp.repository.Response
import com.example.pocofdigivalapp.repository.TextDto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.net.SocketTimeoutException
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

suspend fun <T> handleResponse(api: suspend () -> retrofit2.Response<T?>): Response<T?> {
    try {
        val response = api()
        return if (response.isSuccessful) {
            Response.Success(response.body())
        } else {
            if (!Constants.isNetworkConnected) {
                Response.NoNetwork(R.string.no_network_connection)
            } else {
                val message = getErrorMessageFromGenericResponse(response)
                if (!TextUtils.isEmpty(message)) {
                    Response.Failure(ApiFailure.parseErrorMessage(TextDto(message, message)))
                } else {
                    Response.NoNetwork(R.string.server_error)
                }
            }
        }
    } catch (e: Exception) {
        Log.d("TAG", "handleResponse: ${e.printStackTrace()}", e)
        return if (!Constants.isNetworkConnected) {
            Response.NoNetwork(R.string.no_network_connection)
        } else if (e is NetworkErrorException) {
            Response.NoNetwork(R.string.no_network_connection)
        } else if (e is SocketTimeoutException) {
            Response.NoNetwork(R.string.something_times)
        } else {
            Response.NoNetwork(R.string.something_went_wrong)
        }
    }
}

private fun <T> getErrorMessageFromGenericResponse(response: retrofit2.Response<T?>): String? {
    var errorMessage: String? = null
    try {
        val apiResponse: ApiResponse? = Gson().fromJson(response.errorBody()?.string())
        if (apiResponse != null && TextUtils.isEmpty(apiResponse.message).isFalse()) {
            return apiResponse.message
        }
    } catch (e: java.lang.Exception) {
        Log.e("TAG", "getErrorMessageFromGenericResponse: ", e)
    }
    try {
        val errorBody = response.errorBody()
        if (errorBody != null) {
            val json = errorBody.string()
            val errorParser: CommonApiError? = Gson().fromJson(json)
            val data = errorParser?.data
            if (!data.isNullOrEmpty()) {
                val get = data[0]
                if (!get.isNullOrEmpty()) {
                    if (!TextUtils.isEmpty(get[0])) {
                        errorMessage = get[0]
                    }
                }
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    } finally {
        return errorMessage
    }
}


fun AssetManager.readFile(fileName: String) = open(fileName)
    .bufferedReader()
    .use { it.readText() }

inline fun <reified T> Gson.fromJson(json: String?): T? {
    json ?: return null
    return fromJson<T>(json, object : TypeToken<T>() {}.type)
}


@OptIn(ExperimentalContracts::class)
fun Boolean?.isFalse(): Boolean {
    contract {
        returns(false) implies (this@isFalse == null)
    }
    return this@isFalse == false
}