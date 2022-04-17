package com.example.mvvm_bilalkhan.network

import com.example.mvvm_bilalkhan.network.responses.Login.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface AuthApi {

    @Headers("P-Auth-Token:P4t13nt4idu53r")
    @POST("api/v1/login")
    suspend fun login(
        /*@Field("phone") username : String,
        @Field("password") password : String*/
        @Body loginBodyModel: LoginBodyModel
    ) : LoginResponse

}