package com.example.trackster.userAuthentication.ui


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.teachfriend.R
import com.example.trackster.navigation.AUTHENTICATION_ROUTE
import com.example.trackster.navigation.Screens
import com.example.trackster.uiHelpers.GeneralButton
import com.example.trackster.uiHelpers.GeneralTextField
import com.example.trackster.uiHelpers.PasswordTextField

import com.example.trackster.uiHelpers.generalButtonModifier
import com.example.trackster.uiHelpers.generalTextFieldModifier
import com.example.trackster.userAuthentication.viewModel.AuthViewModel
import com.example.trackster.userAuthentication.viewModel.LoginResult



@Composable
fun LoginScreen(authViewModel: AuthViewModel, navController: NavController) {

    val username = authViewModel.username.collectAsStateWithLifecycle()
    val password = authViewModel.password.collectAsStateWithLifecycle()
    val loginResult = authViewModel.loginResult.collectAsStateWithLifecycle()

    val isButtonLoading = remember { mutableStateOf(false) }
    val showPassword = remember { mutableStateOf(false) }

    MaterialTheme {
        Surface(
            modifier = Modifier,
            shape = MaterialTheme.shapes.extraLarge,
            color = MaterialTheme.colorScheme.background,
            tonalElevation = 4.dp,
            shadowElevation = 4.dp,
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Trackster",
                    modifier = Modifier
                        .padding(10.dp),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.displayLarge,
                )
                Spacer(modifier = Modifier.height(36.dp))

                GeneralTextField(
                    modifier = Modifier.generalTextFieldModifier(),
                    value = username.value,
                    onValueChange = { authViewModel.onUsernameChanged(it) },
                    label = stringResource(id = R.string.credentials),
                    keyboardType = KeyboardType.Text,
                )
                Spacer(modifier = Modifier.height(8.dp))
                PasswordTextField(
                    modifier = Modifier.generalTextFieldModifier(),
                    value = password.value,
                    onValueChange = { authViewModel.onPasswordChanged(it) },
                    label = stringResource(id = R.string.password),
                    keyboardType = KeyboardType.Password,
                    showPassword = showPassword
                )

                Spacer(modifier = Modifier.height(16.dp))
                GeneralButton(
                    modifier = Modifier.generalButtonModifier()
                        .clickable(enabled = !isButtonLoading.value) {
                            isButtonLoading.value = true
                            authViewModel.onLoginClicked()
                        },
                    text = stringResource(id = R.string.logIn),
                    onClick = {
                        authViewModel.onLoginClicked()
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                GeneralButton(
                    text = "Create an Account",
                    onClick = {
                        navController.navigate(route = Screens.Signup.route)
                    }
                )

                    when (loginResult.value) {
                        is LoginResult.Loading -> {
                            // display a loading indicator while the login operation is in progress
                            CircularProgressIndicator()
                        }
                        is LoginResult.Success -> {
                            if ((loginResult.value as LoginResult.Success).message == "Login successful") {
                                navController.navigate(route = Screens.LearnerGroupHome.route) {
                                    launchSingleTop = true
                                    popUpTo(route = AUTHENTICATION_ROUTE) {
                                        inclusive = true
                                    }
                                }
                            }
                            isButtonLoading.value = false
                        }

                        is LoginResult.Error -> {
                            // display an error message if the login operation fails
                            Text(
                                (loginResult.value as LoginResult.Error).message,
                                color = MaterialTheme.colorScheme.error
                            )
                            isButtonLoading.value = false
                        }

                        else -> {}
                    }
            }
        }
    }
}




//@Preview
//@Composable
//fun LoginScreenPreview() {
//    // Create a fake view model with some sample data
//    // Create a fake nav controller
//    val navController = rememberNavController()
//    val fakeViewModel = AuthViewModel(MockAuthRepository()).apply {
//        onUsernameChanged("admin")
//        onPasswordChanged("1234")
//    }
//
//    // Call the LoginScreen function with the fake view model
//    LoginScreen(fakeViewModel, navController = navController)
//}
//
