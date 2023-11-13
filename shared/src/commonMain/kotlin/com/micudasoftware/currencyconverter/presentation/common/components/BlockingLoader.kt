package com.micudasoftware.currencyconverter.presentation.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.micudasoftware.currencyconverter.presentation.common.theme.CurrencyConverterTheme

/**
 * Blocking loader dialog.
 */
@Composable
fun BlockingLoader() {
    Dialog(
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false
        ),
        onDismissRequest = {}
    ) {
        Card(
            shape = RoundedCornerShape(10.dp)
        ) {
            Row(
                modifier = Modifier.padding(
                    horizontal = 32.dp,
                    vertical = 24.dp
                ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularProgressIndicator(
                    color = CurrencyConverterTheme.colors.primary
                )
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = "Loading..."
                )
            }
        }

    }
}