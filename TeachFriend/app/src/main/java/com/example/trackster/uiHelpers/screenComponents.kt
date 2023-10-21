package com.example.trackster.uiHelpers


import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.lifecycle.compose.collectAsStateWithLifecycle


// Create a custom modifier for the home screen

@Composable
fun GeneralTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberTextField(
    value:String,
    onValueChange: (String) -> Unit,
    label:String,
    keyboardType: KeyboardType = KeyboardType.Text
){
    OutlinedTextField(
        value = value ,
        onValueChange = onValueChange,
        label = {Text(text = label)},
        modifier =Modifier,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true
    )
}

@Composable
fun PasswordTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Password,
    showPassword: MutableState<Boolean>,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = modifier,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true,
        visualTransformation = if (showPassword.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        trailingIcon = {
            IconButton(onClick = {
                showPassword.value = !showPassword.value
            }) {
                Icon(Icons.Default.Visibility, null)
            }
        },
    )
}

@Composable
fun GeneralButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    isEnabled:Boolean = false
) {
    Button(
        modifier = modifier,
        onClick = onClick,
    ) {
        Text(text = text)
    }
}