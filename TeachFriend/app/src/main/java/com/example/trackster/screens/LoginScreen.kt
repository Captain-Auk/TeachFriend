package com.example.trackster.screens


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.teachfriend.R
import com.example.trackster.components.GeneralButton
import com.example.trackster.components.GeneralTextField
import com.example.trackster.components.PasswordTextField
import com.example.trackster.ViewModels.LoginViewModel
import com.example.trackster.dataLayer.AuthRepository

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen() {


    val viewModel: LoginViewModel = viewModel()
    val username = viewModel.credentials.collectAsState()
    val password = viewModel.password.collectAsState()
    val loginResult = viewModel.loginResult.collectAsState()

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Login App") },
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                GeneralTextField(
                    value = username.value,
                    onValueChange = { viewModel.onUsernameChanged(it) },
                    label = stringResource(id = R.string.credentials)
                )
                Spacer(modifier = Modifier.height(8.dp))
                PasswordTextField(
                    value = password.value,
                    onValueChange = { viewModel.onPasswordChanged(it) },
                    label = stringResource(id = R.string.password)
                )
                Spacer(modifier = Modifier.height(16.dp))
                GeneralButton(
                    text = stringResource(id = R.string.logIn),
                    onClick = { viewModel.onLoginClicked() }
                )
                Spacer(modifier = Modifier.height(8.dp))
                loginResult.value?.let {
                    Text(text = it, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}


/*@Preview
@Composable
fun LoginScreenPreview() {
    // Create a fake view model with some sample data
    val fakeViewModel = LoginViewModel().apply {
        onUsernameChanged("admin")
        onPasswordChanged("1234")
    }
    // Call the LoginScreen function with the fake view model
    LoginScreen()
}
*/
/*
The GeneralTextField function is a custom composable function that creates an
OutlinedTextField with some predefined parameters. The OutlinedTextField is a composable that
 displays a text field with a thin outline and a label. The GeneralTextField function takes four
  parameters: value, onValueChange, label, and keyboardType. The value parameter is the current
  text displayed in the text field, the onValueChange parameter is a lambda function that is
  invoked when the user changes the text in the text field, the label parameter is the text
  displayed above the text field when it is focused or has some input, and the keyboardType
  parameter is the type of keyboard that is shown when the user taps on the text field. The
  GeneralTextField function passes these parameters to the OutlinedTextField composable,
  along with a modifier that sets the width of the text field to fill the maximum available space.
The username variable is a State<String> object that represents the current value of the username
field in the UI. It is created by calling the collectAsState() function on the
viewModel.username flow, which is a MutableStateFlow<String> property that holds the
 username value in the viewModel. The collectAsState() function collects values from a flow and
  represents them as a Compose State object, which can be used to update and observe UI state.
  The username State object has a value property that returns the current value of the
   username field, and updates its value whenever the viewModel.username flow emits a new value.
The stringResource function is a helper function that returns a localized string from the
resources. It takes an id parameter that is an integer constant defined in the R.string class,
which corresponds to a string resource defined in the res/values/strings.xml file.
The stringResource function returns the string value of the resource with the given id,
 or an empty string if no such resource exists.
The viewModel.onUsernameChanged function is a method defined in the viewModel that takes a
newUsername parameter of type String. It updates the value of the viewModel.username flow
by assigning the newUsername parameter to its value property. This triggers an emission of
a new value from the viewModel.username flow, which in turn updates the username State object
and causes a recomposition of any composable functions that read its value.
When the user types something in the username text field, the onValueChange lambda function is
invoked with the new text as its argument. The lambda function calls the viewModel.onUsernameChanged
 function with the new text as its parameter, which updates the viewModel.username flow and
 triggers a UI update. The username text field displays the new text entered by the user, and
  any other composable functions that depend on the username State object are also recomposed
  with the new value.
* */