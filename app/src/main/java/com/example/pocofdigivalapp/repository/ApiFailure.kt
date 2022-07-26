package com.example.pocofdigivalapp.repository

data class ApiFailure(
    val msg: TextDto,
    val errorCode: String
) : Exception(msg.en) {
    companion object {

        fun parseErrorMessage(msg: TextDto): ApiFailure {
            return ApiFailure(
                msg,
                ""
            )
        }

        fun create(exception: Exception): ApiFailure {
            return if (exception is ApiFailure) {
                exception
            } else ApiFailure(
                TextDto(
                    exception.message.toString(),
                    exception.message.toString()
                ),
                "L0"
            )
        }
    }
}