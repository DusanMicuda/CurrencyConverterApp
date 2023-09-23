package com.micudasoftware.currencyconverter.ui.viewmodel

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.micudasoftware.currencyconverter.data.repository.Repository
import com.micudasoftware.currencyconverter.ui.screen.CurrencyRatesState
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * View model for Currency Rates Screen.
 *
 * @property repository The main repository.
 */
class CurrencyRatesScreenModel(
    private val repository: Repository
): StateScreenModel<CurrencyRatesState>(CurrencyRatesState(rates = emptyList())) {

    init {
        coroutineScope.launch {
            repository.getLatestRates().onSuccess { currencyRates ->
                mutableState.update { CurrencyRatesState(rates = currencyRates) }
            }
        }
    }
}
