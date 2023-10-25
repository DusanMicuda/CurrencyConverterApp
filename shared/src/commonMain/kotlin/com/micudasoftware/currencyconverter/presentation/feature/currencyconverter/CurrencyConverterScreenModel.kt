package com.micudasoftware.currencyconverter.presentation.feature.currencyconverter

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.micudasoftware.currencyconverter.data.repository.Repository
import com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.model.CurrencyConverterEvent
import com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.model.CurrencyConverterState
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Screen model for Currency Converter Screen.
 *
 * @property repository A Data repository.
 */
class CurrencyConverterScreenModel(
    private val repository: Repository,
): StateScreenModel<CurrencyConverterState>(CurrencyConverterState()) {

    init {
        coroutineScope.launch {
            repository.getCurrencies().onSuccess { currencies ->
                mutableState.update { it.copy(currencies = currencies) }
            }
        }
    }

    /**
     * Function to handle occurred events.
     *
     * @param event The occurred [CurrencyConverterEvent].
     */
    fun onEvent(event: CurrencyConverterEvent) {
        when(event) {
            is CurrencyConverterEvent.UpdateCurrencyToConvertValue ->
                mutableState.update {
                    it.copy(
                        fromCurrency = it.fromCurrency.copy(
                            value = event.value
                        )
                    )
                }
            is CurrencyConverterEvent.OnSelectFromCurrency ->
                mutableState.update {
                    it.copy(
                        fromCurrency = it.fromCurrency.copy(
                            currency = event.selectedCurrency
                        )
                    )
                }
            is CurrencyConverterEvent.OnSelectToCurrency ->
                mutableState.update {
                    it.copy(
                        toCurrency = it.toCurrency.copy(
                            currency = event.selectedCurrency
                        )
                    )
                }
            is CurrencyConverterEvent.TurnCurrencies -> {}
            is CurrencyConverterEvent.ConvertCurrency -> convertCurrency()
        }
    }

    /**
     * Function to convert currencies.
     */
    private fun convertCurrency() {
        coroutineScope.launch {
            state.value.fromCurrency.currency?.let { fromCurrency ->
                state.value.toCurrency.currency?.let { toCurrency ->
                    repository.convertCurrency(
                        from = fromCurrency,
                        to = toCurrency,
                        amount = state.value.fromCurrency.value.toDoubleOrNull() ?: 0.0
                    ).onSuccess { convertedCurrency ->
                        mutableState.update {
                            it.copy(
                                toCurrency = it.toCurrency.copy(
                                    value = convertedCurrency.rate.toString()
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}
