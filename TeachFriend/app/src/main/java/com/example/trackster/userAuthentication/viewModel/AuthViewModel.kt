package com.example.trackster.userAuthentication.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trackster.userAuthentication.data.IAuthRepository
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.auth.AuthenticationException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class LoginResult {
    object Loading : LoginResult()
    data class Success(val message: String) : LoginResult()
    data class Error(val message: String) : LoginResult()
}

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val iAuthRepository: IAuthRepository
) : ViewModel() {

    private val _loginResult = MutableStateFlow<LoginResult?>(null)
    val loginResult: StateFlow<LoginResult?> get() = _loginResult

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> get() = _username

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> get() = _password

    fun onUsernameChanged(newUsername: String) {
        _username.value = newUsername
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }

    fun onLoginClicked() {
        val credentials = username.value
        val password = password.value
        _loginResult.value = LoginResult.Loading

        // Validate the credentials locally before sending to the server.
        _loginResult.value = validateLoginCredentials(credentials, password)

        // If the credentials are valid, call the auth repository to authenticate the user.
        if (_loginResult.value is LoginResult.Success) {
            viewModelScope.launch {
                try {
                    _loginResult.value = LoginResult.Loading
                    val token = iAuthRepository.authenticate(credentials, password)
                    _loginResult.value = LoginResult.Success("Login successful")
                } catch (e: AuthenticationException) {
                    _loginResult.value = LoginResult.Error("Network Error")
                }
            }
        }
    }
}
//@HiltViewModel
//class AuthViewModel @Inject constructor (
//    private val IAuthRepository: IAuthRepository,
//) : ViewModel() {
//
//    private val _credentials = MutableStateFlow("")
//    val credentials: MutableStateFlow<String> get() = _credentials
//
//    private val _password = MutableStateFlow("")
//    val password: MutableStateFlow<String> get() = _password
//
//    private val _loginResult = MutableStateFlow<String?>(" ")
//    val loginResult: MutableStateFlow<String?> get() = _loginResult
//
//
//    fun onUsernameChanged(newUsername: String) {
//        _credentials.value = newUsername
//    }
//
//    fun onPasswordChanged(newPassword: String) {
//        _password.value = newPassword
//    }
//    fun onLoginClicked() {
//        val credentials = credentials.value
//        val password = password.value
//
//        // Validate the credentials locally before sending to the server.
//        _loginResult.value = validateLoginCredentials(credentials, password)
//        if (_loginResult.value == "Username and Password validated") {
//            viewModelScope.launch {
//                try {
//                    val token = IAuthRepository.authenticate(credentials, password)
//                    _loginResult.value = "Login successful"
//                } catch (e: AuthenticationException) {
//                    _loginResult.value = "Invalid email or password"
//                }
//            }
//        }
//    }
//}

