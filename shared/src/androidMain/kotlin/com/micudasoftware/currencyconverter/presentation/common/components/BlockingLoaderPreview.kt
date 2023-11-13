package com.micudasoftware.currencyconverter.presentation.common.components

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.micudasoftware.currencyconverter.presentation.common.theme.CurrencyConverterTheme

/**
 * Preview for [BlockingLoader].
 */
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun BlockingLoaderPreview() {
    CurrencyConverterTheme {
        BlockingLoader()
    }
}