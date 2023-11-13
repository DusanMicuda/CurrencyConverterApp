package com.micudasoftware.currencyconverter.presentation.feature.currencyrates

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.micudasoftware.currencyconverter.SharedRes
import com.micudasoftware.currencyconverter.data.repository.Repository
import com.micudasoftware.currencyconverter.data.repository.model.Currency
import com.micudasoftware.currencyconverter.presentation.common.model.ButtonModel
import com.micudasoftware.currencyconverter.presentation.common.model.DialogModel
import com.micudasoftware.currencyconverter.presentation.common.model.LoadingModel
import com.micudasoftware.currencyconverter.presentation.feature.currencyrates.model.CurrencyRatesEvent
import com.micudasoftware.currencyconverter.presentation.feature.currencyrates.model.CurrencyRatesState
import dev.icerock.moko.resources.desc.desc
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
            }.onError {
                handleError()
            }
        }.invokeOnCompletion {
            hideLoading()
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
