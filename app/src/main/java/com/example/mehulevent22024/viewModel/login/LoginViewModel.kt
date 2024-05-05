package com.example.mehulevent22024.viewModel.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mehulevent22024.models.login.LoginResponse
import com.example.mehulevent22024.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getLoginData()
        }
    }

    val login: LiveData<MutableList<LoginResponse>>
        get() = repository.login

}