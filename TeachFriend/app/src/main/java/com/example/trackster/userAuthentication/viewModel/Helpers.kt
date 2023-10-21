package com.example.trackster.userAuthentication.viewModel

import android.text.TextUtils
import android.util.Patterns

/**
 * Check if the password is empty.
 * Check if the password is less than 8 characters long.
 * Check if the password contains at least one uppercase letter.
 * Check if the password contains at least one lowercase letter.
 * Check if the password contains at least one number.
 * Check if the password contains at least one special character.
 */
fun validateLoginCredentials(credentials: String, password: String): LoginResult {
    if (credentials.isEmpty()) {
        return LoginResult.Error("Please enter your email")
    }

    if (password.isEmpty()) {
        return LoginResult.Error("Please enter your password")
    }

    if (!credentials.isEmailValid()) {
        return LoginResult.Error("Invalid email")
    }

//    if (!checkPasswordStrength(password)) {
//        return LoginResult.Error("Password is not strong enough")
//    }

    return LoginResult.Success("Username and Password validated")
}

fun String.isEmailValid(): Boolean {
    return !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}
fun checkPasswordStrength(password: String): Boolean {
    if (password.isEmpty()) {
        return false
    }

    if (password.length < 8) {
        return false
    }

    if (!password.contains("[A-Z]".toRegex())) {
        return false
    }

    if (!password.contains("[a-z]".toRegex())) {
        return false
    }

    if (!password.contains("[0-9]".toRegex())) {
        return false
    }

    if (!password.contains("[!@#$%^&*()_+{}:\";'<>?,./]".toRegex())) {
        return false
    }

    return true
}




