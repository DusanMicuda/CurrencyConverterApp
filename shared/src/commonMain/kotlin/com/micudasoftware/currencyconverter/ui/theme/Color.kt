package com.micudasoftware.currencyconverter.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class Colors(
    val primary: Color,
    val surface: Color,
    val transparent: Color,
    val background: List<Color>,
)

val LightColors: Colors = Colors(
    primary = ColorPalette.Blue,
    surface = ColorPalette.LightCyan,
    transparent = ColorPalette.Transparent,
    background = listOf(ColorPalette.LightBlue, ColorPalette.LightCyan),
)
val DarkColors: Colors = Colors(
    primary = ColorPalette.LightBlue,
    surface = ColorPalette.DarkCyan,
    transparent = ColorPalette.Transparent,
    background = listOf(ColorPalette.DarkBlue, ColorPalette.DarkCyan),
)

val LocalColors = staticCompositionLocalOf { LightColors }

object ColorPalette {
    val LightCyan = Color(0xFF89FFFF)
    val DarkCyan = Color(0xFF004141)
    val LightBlue = Color(0xFF4B7BFF)
    val Blue = Color(0xFF1345FF)
    val DarkBlue = Color(0xFF010157)
    val Transparent = Color(0x00000000)
}