package com.micudasoftware.currencyconverter.presentation.common.model

import dev.icerock.moko.resources.desc.StringDesc

/**
 * Model for composable button.
 *
 * @property text Text to display on the button.
 * @property onClick Lambda function triggered when button is clicked.
 */
data class ButtonModel(
    val text: StringDesc,
    val onClick: () -> Unit,
)
