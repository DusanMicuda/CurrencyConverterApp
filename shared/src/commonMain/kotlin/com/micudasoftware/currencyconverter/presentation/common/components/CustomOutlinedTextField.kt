package com.micudasoftware.currencyconverter.presentation.common.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.micudasoftware.currencyconverter.SharedRes
import com.micudasoftware.currencyconverter.presentation.common.getString
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.desc.StringDesc


/**
 * Custom outlined text field.
 *
 * @param value Value to be shown in the text field.
 * @param modifier Modifier.
 * @param label Label text represented as [StringDesc].
 * @param errorText Error text represented as [StringDesc].
 * @param readOnly Flag indicates if text field is read only.
 * @param onClick Lambda function to override on click event.
 * @param onValueChange Lambda function triggered when value is changed.
 */
@Composable
fun CustomOutlinedTextField(
    value: String,
    modifier: Modifier = Modifier,
    label: StringDesc? = null,
    errorText: StringDesc? = null,
    readOnly: Boolean = false,
    onClick: (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
) {
    val color = if (errorText == null) {
        MaterialTheme.colorScheme.onSurfaceVariant
    } else {
        MaterialTheme.colorScheme.error
    }

    OutlinedTextField(
        modifier = modifier.then(
            onClick?.let {
                Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = it
                )
            } ?: Modifier
        ),
        value = value,
        label = { label?.getString()?.let { Text(it) } },
        supportingText = { errorText?.getString()?.let { Text(it) } },
        isError = errorText != null,
        readOnly = readOnly,
        enabled = !readOnly,
        trailingIcon = {
            onClick?.let {
                IconButton(
                    onClick = it
                ) {
                    Icon(
                        painter = painterResource(SharedRes.images.ic_arrow_drop_down),
                        contentDescription = null
                    )
                }
            }
        },
        onValueChange = onValueChange,
        colors = TextFieldDefaults.colors(
            disabledIndicatorColor = color,
            disabledLabelColor = color,
            disabledTextColor = MaterialTheme.colorScheme.onSurface,
            disabledSupportingTextColor = color,
            disabledTrailingIconColor = color,
        )
    )
}