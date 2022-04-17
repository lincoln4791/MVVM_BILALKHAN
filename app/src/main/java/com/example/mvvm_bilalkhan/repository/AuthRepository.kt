package com.example.mvvm_bilalkhan.repository

import android.util.Log
import com.example.mvvm_bilalkhan.network.AuthApi
import com.example.mvvm_bilalkhan.network.LoginBodyModel

class AuthRepository(private val api : AuthApi) : BaseRepository() {

    suspend fun login(
        userName:String,
        password:String,
    ) = safeApiCAll {
        Log.d("tag","Login CAlled in UTH rePOSITORY u-> $userName :: Pass -> $password ")
        val loginBody = LoginBodyModel()
        loginBody.phone = userName
        loginBody.password = password
        api.login(loginBody)
    }

}