package com.example.mvvm_bilalkhan.repository

import com.example.mvvm_bilalkhan.network.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.lang.Exception

abstract class BaseRepository {

    suspend fun <T> safeApiCAll(
        apiCall : suspend ()->T
    ):Resource<T>{
        return withContext(Dispatchers.IO){
            try {
                Resource.Success(apiCall.invoke())
            }
            catch (throwabel : Throwable){
                when(throwabel){
                    is HttpException -> {
                        Resource.Failure(false,throwabel.code(), throwabel.response()?.errorBody())
                    }
                    else -> Resource.Failure(true,null,null)

                }
            }
        }
    }

}