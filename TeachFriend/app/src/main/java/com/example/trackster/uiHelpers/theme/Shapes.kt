package com.example.trackster.uiHelpers.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

// A custom shapes object that defines the shapes for different components
val shapes = Shapes(
    // The shape for extra small components such as icons and fab
    extraSmall = RoundedCornerShape(4.dp),
    // The shape for small components such as chips, badges, and text fields
    small = RoundedCornerShape(8.dp),
    // The shape for medium components such as cards, dialogs, and menus
    medium = RoundedCornerShape(16.dp),
    // The shape for large components such as sheets, bottom bars, and navigation rails
    large = RoundedCornerShape(24.dp),
    // The shape for extra large components such as full-screen modals and drawers
    extraLarge = RoundedCornerShape(32.dp)
)