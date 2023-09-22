package com.example.teachfriend.ViewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class loginScreenViewModel : ViewModel(){
    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

//    private val _errorMessage = MutableStateFlow("")
//    val errorMessage = StateFlow<String> = _errorMessage

    fun onUsernameChanged(newUsername: String){
        _username.value = newUsername
    }

    fun onPasswordChanged(newPassword: String){
        _password.value = newPassword
    }
    fun onLoginClicked() {
        //TODO: implement login logic here
    }
}