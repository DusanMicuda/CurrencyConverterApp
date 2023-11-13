package com.micudasoftware.currencyconverter.presentation.common.model

/**
 * Sealed class representing loading model.
 *
 */
sealed class LoadingModel {

    /**
     * Local loading model.
     */
    data object Local: LoadingModel()

    /**
     * Blocking loading model.
     */
    data object Blocking: LoadingModel()
}
