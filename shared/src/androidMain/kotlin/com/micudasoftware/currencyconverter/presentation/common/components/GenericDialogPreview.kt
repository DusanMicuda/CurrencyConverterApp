package com.micudasoftware.currencyconverter.presentation.common.components

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.micudasoftware.currencyconverter.presentation.common.model.ButtonModel
import com.micudasoftware.currencyconverter.presentation.common.model.DialogModel
import com.micudasoftware.currencyconverter.presentation.common.theme.CurrencyConverterTheme
import dev.icerock.moko.resources.desc.Raw
import dev.icerock.moko.resources.desc.StringDesc

/**
 * Preview for [GenericDialogPreview].
 */
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
fun GenericDialogPreview() {
    CurrencyConverterTheme {
        GenericDialog(
            dialogModel = DialogModel(
                title = StringDesc.Raw("Title"),
                message = StringDesc.Raw("Lorem ipsum dolor sit amet, consectetur " +
                        "adipiscing elit. Donec nec tellus a orci pretium sodales ac in quam. "),
                positiveButton = ButtonModel(
                    text = StringDesc.Raw("Positive Button"),
                    onClick = {}
                ),
                negativeButton = ButtonModel(
                    text = StringDesc.Raw("Negative Button"),
                    onClick = {}
                ),
                onDismiss = {}
            )
        )
    }
}