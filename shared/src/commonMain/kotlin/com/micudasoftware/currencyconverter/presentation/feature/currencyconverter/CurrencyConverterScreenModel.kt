package com.micudasoftware.currencyconverter.presentation.feature.currencyconverter

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.micudasoftware.currencyconverter.SharedRes
import com.micudasoftware.currencyconverter.data.repository.Repository
import com.micudasoftware.currencyconverter.presentation.common.model.ButtonModel
import com.micudasoftware.currencyconverter.presentation.common.model.DialogModel
import com.micudasoftware.currencyconverter.presentation.common.model.LoadingModel
import com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.model.CurrencyConverterEvent
import com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.model.CurrencyConverterState
import dev.icerock.moko.resources.desc.desc
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
        showLoading(true)
        coroutineScope.launch {
            repository.getCurrencies().onSuccess { currencies ->
                mutableState.update { it.copy(currencies = currencies) }
            }.onError {
                handleError()
            }
        }.invokeOnCompletion {
            hideLoading()
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
                        ).validateValue()
                    )
                }
            is CurrencyConverterEvent.OnSelectFromCurrency ->
                mutableState.update {
                    it.copy(
                        fromCurrency = it.fromCurrency.copy(
                            currency = event.selectedCurrency,
                            currencyError = SharedRes.strings.wrong_currency_error.desc().takeIf {
                                state.value.toCurrency.currency == event.selectedCurrency
                            }
                        ),
                        toCurrency = it.toCurrency.copy(
                            value = "",
                            currencyError = SharedRes.strings.wrong_currency_error.desc().takeIf {
                                event.selectedCurrency == state.value.toCurrency.currency
                            }
                        )
                    )
                }
            is CurrencyConverterEvent.OnSelectToCurrency ->
                mutableState.update {
                    it.copy(
                        fromCurrency = it.fromCurrency.copy(
                            currencyError = SharedRes.strings.wrong_currency_error.desc().takeIf {
                                event.selectedCurrency == state.value.fromCurrency.currency
                            }
                        ),
                        toCurrency = it.toCurrency.copy(
                            value = "",
                            currency = event.selectedCurrency,
                            currencyError = SharedRes.strings.wrong_currency_error.desc().takeIf {
                                state.value.fromCurrency.currency == event.selectedCurrency
                            }
                        )
                    )
                }
            is CurrencyConverterEvent.TurnCurrencies -> turnCurrencies()
            is CurrencyConverterEvent.ConvertCurrency -> convertCurrency()
        }
    }

    /**
     * Function to convert currencies.
     */
    private fun convertCurrency() {
        showLoading()
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
                    }.onError {
                        handleError()
                    }
                }
            }
        }.invokeOnCompletion {
            hideLoading()
        }
    }

    private fun turnCurrencies() {
        mutableState.update {
            it.copy(
                fromCurrency = it.toCurrency,
                toCurrency = it.fromCurrency
            )
        }
    }

    /**
     * Function to show error dialog.
     */
    private fun handleError() {
        mutableState.update {
            it.copy(
                dialogModel = DialogModel(
                    title = SharedRes.strings.error_dialog_title.desc(),
                    message = SharedRes.strings.error_dialog_message.desc(),
                    positiveButton = ButtonModel(
                        text = SharedRes.strings.error_dialog_button_close.desc(),
                        onClick = ::closeDialog
                    ),
                    onDismiss = ::closeDialog
                )
            )
        }
    }

    /**
     * Function to close dialogs.
     */
    private fun closeDialog() = mutableState.update { it.copy(dialogModel = null) }

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
