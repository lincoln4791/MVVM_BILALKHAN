package com.example.mvvm_bilalkhan.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_bilalkhan.repository.AuthRepository
import com.example.mvvm_bilalkhan.repository.BaseRepository
import com.example.mvvm_bilalkhan.ui.auth.AuthViewModel
import java.lang.IllegalStateException

@Suppress("Unchecked Cast")
class ViewModelFactory(
    private val repository : BaseRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return when{
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository ) as T
           else -> throw IllegalStateException("ViewModel Class Not Found")
        }
    }

}