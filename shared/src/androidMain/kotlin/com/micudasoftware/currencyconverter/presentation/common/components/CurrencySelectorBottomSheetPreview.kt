package com.micudasoftware.currencyconverter.presentation.common.components

import android.content.res.Configuration
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import com.micudasoftware.currencyconverter.data.repository.model.Currency
import com.micudasoftware.currencyconverter.presentation.common.theme.CurrencyConverterTheme

/**
 * Preview for [CurrencySelectorBottomSheet].
 */
@OptIn(ExperimentalMaterialApi::class)
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun CurrencySelectorBottomSheetPreview() {
    CurrencyConverterTheme {
        BottomSheetNavigator(
            sheetShape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
        ) {
            CurrencySelectorBottomSheet(
                currencies = listOf(
                    Currency("EUR", 1.23),
                    Currency("USD", 3.21),
                    Currency("AFN", 2.31),
                    Currency("AED", 3.12),
                    Currency("CZK", 1.32),
                ),
                onSelectCurrency = {}
            ).Content()
        }
    }
}