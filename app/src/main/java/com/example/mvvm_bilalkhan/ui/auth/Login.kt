package com.example.mvvm_bilalkhan.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.mvvm_bilalkhan.R
import com.example.mvvm_bilalkhan.databinding.FragmentLoginBinding
import com.example.mvvm_bilalkhan.network.AuthApi
import com.example.mvvm_bilalkhan.network.Resource
import com.example.mvvm_bilalkhan.repository.AuthRepository
import com.example.mvvm_bilalkhan.ui.base.BaseFragment

class Login : BaseFragment<AuthViewModel,FragmentLoginBinding,AuthRepository>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPass.text.toString().trim()

            viewModel.login(username,password)
        }

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success -> {
                    if(it.value.success == "true"){
                        Toast.makeText(requireContext(),"Login Success",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(requireContext(),"Wrong Pass",Toast.LENGTH_SHORT).show()
                    }

                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Login Failed", Toast.LENGTH_SHORT).show()
                }
            }
        })

    }


    override fun getViewModel() = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentLoginBinding.inflate(inflater,container,false)

    override fun getFragmentRepository() = AuthRepository(remoteDataSource.buildApi(AuthApi::class.java))


}