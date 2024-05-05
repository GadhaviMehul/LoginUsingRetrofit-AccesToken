package com.example.mehulevent22024.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mehulevent22024.R
import com.example.mehulevent22024.api.ApiService
import com.example.mehulevent22024.api.RetrofitHelper
import com.example.mehulevent22024.databinding.FragmentLoginBinding
import com.example.mehulevent22024.models.login.LoginRequest
import com.example.mehulevent22024.models.login.LoginResponse
import com.example.mehulevent22024.repository.LoginRepository
import com.example.mehulevent22024.viewModel.login.LoginViewModel
import com.example.mehulevent22024.viewModel.login.LoginViewModelFactory
import com.google.android.material.snackbar.Snackbar


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var repository: LoginRepository
    private lateinit var viewModel: LoginViewModel
    
    //email:fq@mailinator.com
    //password:Test@123
   //user_device_id:1
   //fcm_token:1
    
    private val userDeviceId = "1"
    private val fcmToken = "1"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        setUpLoginButton()
        return binding.root
    }

    private fun setUpLoginButton() {

        binding.loginButton.setOnClickListener {
            val loginRequestModel = createLoginRequestModel()
            val apiService = RetrofitHelper.getUserData().create(ApiService::class.java)
            repository = LoginRepository(apiService, loginRequestModel)
            viewModel =
                ViewModelProvider(
                    this,
                    LoginViewModelFactory(repository)
                )[LoginViewModel::class.java]
            observeUserData()

        }
    }

    private fun createLoginRequestModel(): LoginRequest {
        return LoginRequest(
            binding.email.text.toString(),
            binding.password.text.toString(),
            userDeviceId,
            fcmToken
        )
    }

    private fun observeUserData() {
        viewModel.login.observe(viewLifecycleOwner) { userData ->
            userData.firstOrNull()?.let {

                // binding.textView.text = it.data.email.toString()

                val action = LoginFragmentDirections.actionLoginFragmentToEventFragment(it)
                findNavController().navigate(action)
                showSnackBar("Login Successfully")
            }
        }
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

}
