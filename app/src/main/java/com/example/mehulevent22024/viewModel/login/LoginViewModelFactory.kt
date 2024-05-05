package com.example.mehulevent22024.viewModel.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mehulevent22024.repository.LoginRepository

class LoginViewModelFactory(private val repository: LoginRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(repository) as T
    }
}