package com.micudasoftware.currencyconverter.presentation.feature.currencyrates.model

import com.micudasoftware.currencyconverter.data.repository.model.Currency
import com.micudasoftware.currencyconverter.data.repository.model.CurrencyRate
import com.micudasoftware.currencyconverter.presentation.common.model.DialogModel
import com.micudasoftware.currencyconverter.presentation.common.model.LoadingModel

/**
 * Data class representing view state for Currency Rates Screen.
 *
 * @property baseCurrency A base currency for which will be currency rates displayed.
 * @property currencies All available currencies.
 * @property rates The currency rates to be shown on screen.
 * @property loadingModel The [LoadingModel] to show/hide loadings.
 * @property dialogModel The [DialogModel] to show dialogs.
 */
data class CurrencyRatesState(
    val baseCurrency: Currency? = null,
    val currencies: List<Currency> = emptyList(),
    val rates: List<CurrencyRate> = emptyList(),
    val loadingModel: LoadingModel? = null,
    val dialogModel: DialogModel? = null,
)
