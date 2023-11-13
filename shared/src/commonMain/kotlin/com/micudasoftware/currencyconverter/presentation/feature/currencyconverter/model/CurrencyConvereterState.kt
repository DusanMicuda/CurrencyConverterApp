package com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.model

import com.micudasoftware.currencyconverter.data.repository.model.Currency
import com.micudasoftware.currencyconverter.presentation.common.model.DialogModel
import com.micudasoftware.currencyconverter.presentation.common.model.LoadingModel

/**
 * View state for Currency Converter Screen.
 *
 * @property currencies All available currencies.
 * @property fromCurrency Currency to be converted.
 * @property toCurrency Converted currency.
 * @property loadingModel The [LoadingModel] to show/hide loadings.
 * @property dialogModel The [DialogModel] to show dialogs.
 */
data class CurrencyConverterState(
    val currencies: List<Currency> = emptyList(),
    val fromCurrency: CurrencyModel = CurrencyModel(),
    val toCurrency: CurrencyModel = CurrencyModel(),
    val loadingModel: LoadingModel? = null,
    val dialogModel: DialogModel? = null,
)