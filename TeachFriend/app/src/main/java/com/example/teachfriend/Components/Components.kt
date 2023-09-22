package com.example.teachfriend.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.Visibility
import com.example.teachfriend.R

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun headText(labelValue: String){
    Text(
        text=labelValue,
        modifier = Modifier
            .fillMaxWidth().heightIn(min = 120.dp)
            .padding(16.dp),
        textAlign = TextAlign.Center
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun generalTextField(labelValue: String){

    val textValue = remember { mutableStateOf("") }
    OutlinedTextField(
        value = textValue.value,
        singleLine = true,
        onValueChange = { textValue.value = it },
       //leadingIcon
        label = { Text(text = labelValue) },
        modifier = Modifier
            .padding(4.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun passwordTextField(labelValue: String){

    val password = remember {
        mutableStateOf("")
    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = password.value,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        onValueChange = { password.value = it },
        //leadingIcon
        trailingIcon = {
                       val iconImage = if (passwordVisible.value){
                           Icons.Filled.Visibility
                       }else{
                           Icons.Filled.VisibilityOff
                       }
            var description =
                if(passwordVisible.value)
               stringResource(id = R.string.hidePassword)
            else stringResource(id = R.string.showPassword)
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None
                                else  PasswordVisualTransformation()
        ,
        label = { Text(text = labelValue) },
        modifier = Modifier
            .padding(4.dp)
    )
}

@Composable
fun generalButton (labelValue: String){
    Button(
        onClick = { /* loginScreenViewModel.onLoginClicked() */ },
        modifier = Modifier.padding(16.dp)
    ) {
        Text((stringResource(id = R.string.signIn)))
    }
}