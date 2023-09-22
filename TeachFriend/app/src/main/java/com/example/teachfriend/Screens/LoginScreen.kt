package com.example.teachfriend.Screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.teachfriend.Components.generalButton
import com.example.teachfriend.Components.generalTextField
import com.example.teachfriend.Components.headText
import com.example.teachfriend.Components.passwordTextField
import com.example.teachfriend.R
import com.example.teachfriend.ViewModels.loginScreenViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
  //  val username by loginScreenViewModel.username.collectAsState()
  //  val password by loginScreenViewModel.password.collectAsState()
    //val errorMessage by loginScreenViewModel.errorMessage.collectAsState()
    // Observe the userIsAuthenticated state value
    //val userIsAuthenticated by loginScreenViewModel.userIsAuthenticated.collectAsState()
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,),
        modifier = modifier
            .fillMaxSize()
            .padding(28.dp)
          //  .size(width = 240.dp, height = 100.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            headText(labelValue = stringResource(id = R.string.appName))
            Spacer(modifier = Modifier.height(16.dp))
            generalTextField(labelValue = stringResource(id = R.string.username))
            Spacer(modifier = Modifier.height(16.dp))
            passwordTextField(labelValue = stringResource(id = R.string.password))
            Spacer(modifier = Modifier.height(16.dp))
            generalButton(labelValue = stringResource(id = R.string.signIn))
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen(){

    LoginScreen()

}


