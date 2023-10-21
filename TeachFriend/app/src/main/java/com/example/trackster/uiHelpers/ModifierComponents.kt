package com.example.trackster.uiHelpers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDefaults.contentColor
import androidx.compose.material3.contentColorFor
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.trackster.uiHelpers.theme.shapes
import com.example.trackster.uiHelpers.theme.typography

fun Modifier.generalTextFieldModifier(): Modifier = composed {
    // Add padding and margin
    padding(0.dp)
    // Change the background color
    background(color = MaterialTheme.colorScheme.onPrimaryContainer)
    shadow(elevation = 4.dp)

    // Return the modified composable
    this
}

fun Modifier.generalButtonModifier(): Modifier = composed {
    // Add padding and margin
    padding(4.dp)
    shapes.large
    // Change the background color
    //background(color = MaterialTheme.colorScheme.onPrimaryContainer)
    contentColorFor(backgroundColor = MaterialTheme.colorScheme.tertiary)
    shadow(elevation = 4.dp)

    // Return the modified composable
    this
}


fun Modifier.bannerModifier(): Modifier = composed {
    padding(10.dp)
    shapes.extraLarge
    typography.displayLarge
    background(color = MaterialTheme.colorScheme.primary)
    this
}