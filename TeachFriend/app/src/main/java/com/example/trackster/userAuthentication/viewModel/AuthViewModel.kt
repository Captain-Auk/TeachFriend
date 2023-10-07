package com.example.trackster.userAuthentication.viewModel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trackster.userAuthentication.data.authRepository
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthenticationException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor (
    private val authRepository: authRepository,
) : ViewModel() {

    private val _credentials = MutableStateFlow("")
    val credentials: MutableStateFlow<String> get() = _credentials

    private val _password = MutableStateFlow("")
    val password: MutableStateFlow<String> get() = _password

    private val _loginResult = MutableStateFlow<String?>(" ")
    val loginResult: MutableStateFlow<String?> get() = _loginResult


    fun onUsernameChanged(newUsername: String) {
        _credentials.value = newUsername
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }

    fun onLoginClicked()  {
        Log.d("LoginResult", "loginResult value is ${loginResult.value}")
        Log.d("LoginScreenViewModel", "OnLoginClicked function reached")
        if (credentials.value.isNullOrEmpty()) {
            Log.d("LoginResult", "loginResult value in credentials.value.isNullOrEmpty() is $loginResult")
            _loginResult.value = "Please enter your credentials"
            return
        }

        if (password.value.isNullOrEmpty()) {
            Log.d("LoginResult empty", "loginResult value is $loginResult.value")
            _loginResult.value = "Please enter your password"
            return
        }
        if ((credentials.value).isEmailValid()) {
            viewModelScope.launch {
                try {
                    Log.d("LoginResult try", "loginResult value is $loginResult.value")
                    val token = authRepository.authenticate(credentials.value, password.value)
                    _loginResult.value = "Login successful"
                    Log.d("LoginScreenViewModel2", "OnLoginClicked function executed, login success")
                    Log.d("LoginResult after successfull", "loginResult value is $loginResult.value")

                } catch (e: AuthenticationException) {
                    _loginResult.value = "Invalid Email or Invalid Password"
                    Log.d("LoginScreenViewModel", "OnLoginClicked function executed invalid email")
                }
            }
        } else
            _loginResult.value = "Invalid Email"
        Log.d("LoginScreenViewModel", "OnLoginClicked function executed, invalid email")
    }

}

