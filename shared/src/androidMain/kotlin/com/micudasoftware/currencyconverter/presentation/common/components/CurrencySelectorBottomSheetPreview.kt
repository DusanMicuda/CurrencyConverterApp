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
import dev.icerock.moko.resources.desc.Raw
import dev.icerock.moko.resources.desc.StringDesc

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
                    Currency("EUR", StringDesc.Raw("Euro")),
                    Currency("USD", StringDesc.Raw("American dollar")),
                    Currency("AFN", StringDesc.Raw("Afghan afghani")),
                    Currency("AED", StringDesc.Raw("United Arab Emirates dirham")),
                    Currency("CZK", StringDesc.Raw("Czech koruna")),
                ),
                onSelectCurrency = {}
            ).Content()
        }
    }
}