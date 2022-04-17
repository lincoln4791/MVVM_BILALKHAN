package com.example.mvvm_bilalkhan.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_bilalkhan.network.Resource
import com.example.mvvm_bilalkhan.network.responses.Login.LoginResponse
import com.example.mvvm_bilalkhan.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository):ViewModel() {

    private val _loginResponse : MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse : LiveData<Resource<LoginResponse>>
    get() = _loginResponse

    fun login(
        username:String,
        password:String
    ) = viewModelScope.launch {
        _loginResponse.value = repository.login(username,password)
    }

}