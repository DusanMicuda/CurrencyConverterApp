package com.micudasoftware.currencyconverter.ui.viewmodel

import com.micudasoftware.currencyconverter.data.repository.Repository
import com.micudasoftware.currencyconverter.ui.screen.CurrencyRatesState
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * View model for Currency Rates Screen.
 *
 * @property repository The main repository.
 */
class CurrencyRatesViewModel(
    private val repository: Repository
): KMMViewModel() {

    private val _viewState = MutableStateFlow(CurrencyRatesState(rates = emptyList()))
    val viewState = _viewState.asStateFlow()

    init {
        viewModelScope.coroutineScope.launch {
            repository.getLatestRates().onSuccess { currencyRates ->
                _viewState.update { CurrencyRatesState(rates = currencyRates) }
            }
        }
    }
}
