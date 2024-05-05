package com.example.mehulevent22024.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mehulevent22024.api.ApiService
import com.example.mehulevent22024.models.login.LoginRequest
import com.example.mehulevent22024.models.login.LoginResponse

class LoginRepository(private val apiService: ApiService, private val loginRequest: LoginRequest) {

    private var loginLiveData = MutableLiveData<MutableList<LoginResponse>>()

    val login: LiveData<MutableList<LoginResponse>>
        get() = loginLiveData

    suspend fun getLoginData() {
        val temp = apiService.getLoginData(loginRequest)
        if (temp.body() != null) {
            loginLiveData.postValue(mutableListOf(temp.body()!!))

        }
    }
}