package com.example.trackster.ViewModels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.trackster.dataLayer.AuthRepository
import com.example.trackster.dataLayer.AuthRepositoryImpl
import com.example.trackster.dataLayer.RemoteDataSource
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthenticationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {

    constructor() : this(AuthRepositoryImpl(RemoteDataSource()))

    private val _credentials = MutableStateFlow("")
    val credentials: MutableStateFlow<String> get() = _credentials

    private val _password = MutableStateFlow("")
    val password: MutableStateFlow<String> get() = _password

    private val _loginResult = MutableStateFlow<String?>(null)
    val loginResult: MutableStateFlow<String?> get() = _loginResult

    fun onUsernameChanged(newUsername: String) {
        _credentials.value = newUsername
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }

    fun onLoginClicked() {
        if((credentials.value).isEmailValid()){
            viewModelScope.launch {
                      try {
                        val token = authRepository.authenticate(credentials.value, password.value)
                        _loginResult.value = "Login successful"
                    } catch (e: AuthenticationException) {
                        _loginResult.value = "Invalid credentials"
                    }
                }
            }else
            _loginResult.value= "Invalid Email"
    }
}

