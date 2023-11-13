package com.micudasoftware.currencyconverter.presentation.common.components

import androidx.compose.material.TextButton
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import com.micudasoftware.currencyconverter.presentation.common.getString
import com.micudasoftware.currencyconverter.presentation.common.model.ButtonModel
import com.micudasoftware.currencyconverter.presentation.common.model.DialogModel
import com.micudasoftware.currencyconverter.presentation.common.theme.CurrencyConverterTheme

/**
 * Composable generic dialog.
 *
 * @param dialogModel [DialogModel] for the generic dialog.
 */
@Composable
fun GenericDialog(
    dialogModel: DialogModel,
) {
    AlertDialog(
        title = {
            Text(
                text = dialogModel.title.getString(),
                style = CurrencyConverterTheme.typography.titleMedium,
            )
        },
        text = {
            Text(text = dialogModel.message.getString(),)
        },
        confirmButton = {
            AlertDialogButton(buttonModel = dialogModel.positiveButton)
        },
        dismissButton = {
            dialogModel.negativeButton?.let {
                AlertDialogButton(buttonModel = dialogModel.negativeButton)
            }
        },
        onDismissRequest = dialogModel.onDismiss,
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    )
}

/**
 * Composable button for [AlertDialog].
 *
 * @param buttonModel [ButtonModel] for alert dialog button.
 */
@Composable
private fun AlertDialogButton(
    buttonModel: ButtonModel,
) {
    TextButton(
        onClick = buttonModel.onClick,
    ) {
        Text(
            text = buttonModel.text.getString(),
            textAlign = TextAlign.Center
        )
    }
}