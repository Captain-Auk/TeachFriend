package com.example.trackster.uiHelpers.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


// Set of Material typography styles to start with
val typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Black,
        fontSize = 96.sp,
        lineHeight = 112.sp,
        letterSpacing = (-1.5).sp
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 72.sp,
        lineHeight = 88.sp,
        letterSpacing = (-1).sp
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 60.sp,
        lineHeight = 72.sp,
        letterSpacing = (-0.5).sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 48.sp,
        lineHeight = 56.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 40.sp,
        lineHeight = 48.sp,
        letterSpacing = 0.15.sp
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 34.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.25.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.15.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall= TextStyle(
        fontFamily=FontFamily.Serif,
        fontWeight=FontWeight.Normal,
        fontSize=14.sp,
        lineHeight=20.sp,
        letterSpacing=0.25.sp
    ),
    labelLarge=TextStyle(
        fontFamily=FontFamily.Monospace,
        fontWeight=FontWeight.Light,
        fontSize=16.sp,
        lineHeight=24.sp,
        letterSpacing=0.15.sp
    ),
    labelMedium=TextStyle(
        fontFamily=FontFamily.Monospace,
        fontWeight=FontWeight.Light,
        fontSize=14.sp,
        lineHeight=20.sp,
        letterSpacing=0.25.sp
    ),
    labelSmall=TextStyle(
        fontFamily=FontFamily.Monospace,
        fontWeight=FontWeight.Light,
        fontSize=12.sp,
        lineHeight=16.sp,
        letterSpacing=0.4.sp
    )
)