package com.micudasoftware.currencyconverter.presentation.common.model

import dev.icerock.moko.resources.desc.StringDesc

/**
 * Model for composable dialog.
 *
 * @property title Title of the dialog.
 * @property message Message of the dialog.
 * @property onDismiss Lambda function triggered when dialog is dismissed.
 * @property positiveButton [ButtonModel] for the positive button.
 * @property negativeButton [ButtonModel] for the negative button.
 */
data class DialogModel(
    val title: StringDesc,
    val message: StringDesc,
    val onDismiss: () -> Unit,
    val positiveButton: ButtonModel,
    val negativeButton: ButtonModel? = null,
)
