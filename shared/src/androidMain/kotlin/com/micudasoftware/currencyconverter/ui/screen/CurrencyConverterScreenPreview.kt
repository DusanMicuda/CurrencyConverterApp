package com.micudasoftware.currencyconverter.ui.screen

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.micudasoftware.currencyconverter.ui.theme.CurrencyConverterTheme

/**
 * Screen preview for [CurrencyConverterScreen].
 */
@Preview
@Composable
fun CurrencyConverterScreenPreview() {
    CurrencyConverterTheme {
        CurrencyConverterScreen.Screen(
            viewState = CurrencyConverterState(),
            onEvent = {}
        )
    }
}

/**
 * Screen preview for [CurrencyConverterScreen] in Dark mode.
 */
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun CurrencyConverterScreenPreviewDark() {
    CurrencyConverterTheme {
        CurrencyConverterScreen.Screen(
            viewState = CurrencyConverterState(),
            onEvent = {}
        )
    }
}