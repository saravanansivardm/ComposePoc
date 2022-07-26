package com.example.pocofdigivalapp.repository

import com.example.pocofdigivalapp.api.ApiService
import com.example.pocofdigivalapp.data.forgotpassword.ForgotPasswordCredentialModel
import com.example.pocofdigivalapp.data.forgotpassword.ForgotPasswordResponse
import com.example.pocofdigivalapp.data.signup.CredentialModel
import com.example.pocofdigivalapp.data.signup.SignupResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface NewAuthService : ApiService {

    @POST("/v2/users/userSignUp")
    suspend fun login(
        @Body credentials: CredentialModel
    ): Response<SignupResponse?>

    @PUT("/v2/users/userRegistration")
    suspend fun setNewPassword(
        @Body forgotPasswordCredentialModel: ForgotPasswordCredentialModel
    ): Response<ForgotPasswordResponse?>

}