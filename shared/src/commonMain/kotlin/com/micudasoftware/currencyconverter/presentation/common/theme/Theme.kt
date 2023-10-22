package com.micudasoftware.currencyconverter.presentation.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun CurrencyConverterTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = when {
        darkTheme -> DarkColors
        else -> LightColors
    }

    val colorScheme = if (darkTheme) {
        darkColorScheme(
            primary = DarkColors.primary,
            surface = DarkColors.surface,
        )
    } else {
        lightColorScheme(
            primary = LightColors.primary,
            surface = LightColors.surface,
        )
    }

    CompositionLocalProvider(
        LocalColors provides colors
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = CurrencyConverterTheme.typography,
            content = content
        )
    }
}

object CurrencyConverterTheme {

    /**
     * Retrieves the current [Colors] at the call site's position in the hierarchy.
     */
    val colors: Colors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    /**
     * Retrieves the current [Typography] at the call site's position in the hierarchy.
     */
    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = Typography

}
