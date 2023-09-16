package com.micudasoftware.currencyconverter.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.micudasoftware.currencyconverter.data.repository.Repository
import com.micudasoftware.currencyconverter.ui.screen.CurrencyRatesState
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
): ViewModel() {

    private val _viewState = MutableStateFlow(CurrencyRatesState(rates = emptyList()))
    val viewState = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getLatestRates().onSuccess { currencyRates ->
                _viewState.update { CurrencyRatesState(rates = currencyRates) }
            }
        }
    }
}
