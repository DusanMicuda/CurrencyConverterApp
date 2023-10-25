package com.micudasoftware.currencyconverter.presentation.screen

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.micudasoftware.currencyconverter.data.repository.model.CurrencyRate
import com.micudasoftware.currencyconverter.presentation.common.theme.CurrencyConverterTheme
import com.micudasoftware.currencyconverter.presentation.feature.currencyrates.CurrencyRatesScreen
import com.micudasoftware.currencyconverter.presentation.feature.currencyrates.model.CurrencyRatesState
import dev.icerock.moko.resources.desc.Raw
import dev.icerock.moko.resources.desc.StringDesc

/**
 * Preview for [CurrencyRatesScreen].
 */
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun CurrencyRatesScreenPreview() {
    CurrencyConverterTheme {
        CurrencyRatesScreen.Screen(
            viewState = CurrencyRatesState(
                listOf(
                    CurrencyRate("EUR", 1.23, StringDesc.Raw("Euro")),
                    CurrencyRate("USD", 3.21, StringDesc.Raw("American dollar")),
                    CurrencyRate("AFN", 2.31, StringDesc.Raw("Afghan afghani")),
                    CurrencyRate("AED", 3.12, StringDesc.Raw("United Arab Emirates dirham")),
                    CurrencyRate("CZK", 1.32, StringDesc.Raw("Czech koruna")),
                )
            )
        )
    }
}
