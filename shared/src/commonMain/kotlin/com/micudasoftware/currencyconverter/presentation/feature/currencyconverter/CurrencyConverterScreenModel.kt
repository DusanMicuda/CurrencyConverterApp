package com.micudasoftware.currencyconverter.presentation.feature.currencyconverter

import cafe.adriel.voyager.core.model.StateScreenModel
import com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.model.CurrencyConverterEvent
import com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.model.CurrencyConverterState

/**
 * Screen model for Currency Converter Screen.
 */
class CurrencyConverterScreenModel: StateScreenModel<CurrencyConverterState>(CurrencyConverterState()) {

    /**
     * Function to handle occurred events.
     *
     * @param event
     */
    fun onEvent(event: CurrencyConverterEvent) {

    }

}
