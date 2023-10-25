package com.micudasoftware.currencyconverter.presentation.common.components

import android.content.res.Configuration
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import com.micudasoftware.currencyconverter.data.repository.model.CurrencyRate
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
                    CurrencyRate("EUR", 1.23, StringDesc.Raw("Euro")),
                    CurrencyRate("USD", 3.21, StringDesc.Raw("American dollar")),
                    CurrencyRate("AFN", 2.31, StringDesc.Raw("Afghan afghani")),
                    CurrencyRate("AED", 3.12, StringDesc.Raw("United Arab Emirates dirham")),
                    CurrencyRate("CZK", 1.32, StringDesc.Raw("Czech koruna")),
                ),
                onSelectCurrency = {}
            ).Content()
        }
    }
}