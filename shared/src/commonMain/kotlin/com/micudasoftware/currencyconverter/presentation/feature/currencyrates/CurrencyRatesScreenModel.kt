package com.micudasoftware.currencyconverter.presentation.feature.currencyrates

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.micudasoftware.currencyconverter.data.repository.Repository
import com.micudasoftware.currencyconverter.data.repository.model.Currency
import com.micudasoftware.currencyconverter.presentation.common.model.LoadingModel
import com.micudasoftware.currencyconverter.presentation.feature.currencyrates.model.CurrencyRatesEvent
import com.micudasoftware.currencyconverter.presentation.feature.currencyrates.model.CurrencyRatesState
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * View model for Currency Rates Screen.
 *
 * @property repository The main repository.
 */
class CurrencyRatesScreenModel(
    private val repository: Repository
): StateScreenModel<CurrencyRatesState>(CurrencyRatesState()) {

    init {
        showLoading(isBlocking = true)
        coroutineScope.launch {
            repository.getCurrencies().onSuccess { currencies ->
                mutableState.update { CurrencyRatesState(currencies = currencies) }
            }
        }.invokeOnCompletion {
            hideLoading()
        }
    }

    /**
     * Function to handle occurred events.
     *
     * @param event The occurred [CurrencyRatesEvent].
     */
    fun onEvent(event: CurrencyRatesEvent) {
        when (event) {
            is CurrencyRatesEvent.OnBaseCurrencySelected -> {
                mutableState.update { it.copy(baseCurrency = event.selectedCurrency) }
                getCurrencyRates(event.selectedCurrency)
            }
        }
    }

    /**
     * Function to get and display currency rates for the given [baseCurrency].
     *
     * @param baseCurrency A Currency that was selected as base currency to get currency rates.
     */
    private fun getCurrencyRates(baseCurrency: Currency) {
        showLoading()
        coroutineScope.launch {
            repository.getLatestRates(baseCurrency).onSuccess { currencyRates ->
                mutableState.update { it.copy(rates = currencyRates) }
            }
        }.invokeOnCompletion {
            hideLoading()
        }
    }

    /**
     * Function to show loading.
     *
     * @param isBlocking Flag indicates if loading should be [LoadingModel.Blocking].
     */
    private fun showLoading(isBlocking: Boolean = false) =
        mutableState.update {
            it.copy(
                loadingModel = if (isBlocking) {
                    LoadingModel.Blocking
                } else {
                    LoadingModel.Local
                }
            )
        }

    /**
     * Function to hide loading.
     */
    private fun hideLoading() = mutableState.update { it.copy(loadingModel = null) }
}
