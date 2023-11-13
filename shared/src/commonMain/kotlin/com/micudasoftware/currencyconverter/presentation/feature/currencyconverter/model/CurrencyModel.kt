package com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.model

import com.micudasoftware.currencyconverter.SharedRes
import com.micudasoftware.currencyconverter.data.repository.model.Currency
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc

/**
 * Model for currency.
 *
 * @property value Value of the currency.
 * @property valueError Error message shown if value is incorrect.
 * @property currency A Currency.
 * @property currencyError Error message shown if currency is incorrect.
 * @property isValid Flag indicates if both value and currency are valid.
 */
data class CurrencyModel(
    val value: String = "",
    val valueError: StringDesc? = null,
    val currency: Currency? = null,
    val currencyError: StringDesc? = null,
) {
    val isValid = value.toDoubleOrNull() != null && currency != null && currencyError == null

    /**
     * Function to validate [CurrencyModel].
     *
     * @return Validated [CurrencyModel].
     */
    fun validateValue() = this.copy(
        valueError = SharedRes.strings.wrong_value_error.desc().takeIf {
            value.toDoubleOrNull() == null
        }
    )
}