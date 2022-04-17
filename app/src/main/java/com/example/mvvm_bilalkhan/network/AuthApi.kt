package com.example.mvvm_bilalkhan.network

import retrofit2.http.Field
import retrofit2.http.POST

interface AuthApi {

    @POST("api/v1/login")
    fun login(
        @Field("username") username : String,
        @Field("password") password : String
    ) : Any

}