package com.micudasoftware.currencyconverter.ui.screenmodel

import cafe.adriel.voyager.core.model.StateScreenModel
import com.micudasoftware.currencyconverter.ui.screen.CurrencyConverterEvent
import com.micudasoftware.currencyconverter.ui.screen.CurrencyConverterState

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
