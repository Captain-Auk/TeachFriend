package com.example.trackster.uiHelpers

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberTextField(
    value:String,
    onValueChange: (String) -> Unit,
    label:String,
    keyboardType: KeyboardType = KeyboardType.Number
){
    OutlinedTextField(
        value = value ,
        onValueChange = onValueChange,
        label = {Text(text = label)},
        modifier =Modifier,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}
@Composable
fun GeneralTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true
    )
}

@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    GeneralTextField(
        value = value,
        onValueChange = onValueChange,
        label = label,
        keyboardType = KeyboardType.Password,
        //visualTransformation = PasswordVisualTransformation()
    )
}

@Composable
fun GeneralButton(
    text: String,
    onClick: () -> Unit,
    isEnabled:Boolean = false
) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = text)
    }
}