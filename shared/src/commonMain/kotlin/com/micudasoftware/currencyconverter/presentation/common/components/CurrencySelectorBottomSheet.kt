package com.micudasoftware.currencyconverter.presentation.common.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import com.micudasoftware.currencyconverter.SharedRes
import com.micudasoftware.currencyconverter.data.repository.model.Currency
import com.micudasoftware.currencyconverter.presentation.common.getString
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

/**
 * Bottom sheet selector to select currency.
 *
 * @param currencies List of selectable currencies.
 * @param onSelectCurrency Lambda function that is called on currency select.
 */
class CurrencySelectorBottomSheet(
    private val currencies: List<Currency>,
    private val onSelectCurrency: (Currency) -> Unit
): Screen {

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun Content() {
        val bottomSheetNavigator = LocalBottomSheetNavigator.current

        Surface(
            color = MaterialTheme.colorScheme.surfaceVariant
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(start = 48.dp),
                        text = stringResource(SharedRes.strings.select_base_currency),
                        textAlign = TextAlign.Center,
                    )
                    IconButton(
                        modifier = Modifier
                            .padding(end = 24.dp)
                            .size(24.dp),
                        onClick = { bottomSheetNavigator.hide() }
                    ) {
                        Icon(
                            painterResource(SharedRes.images.ic_close),
                            contentDescription = null
                        )
                    }
                }
                LazyColumn {
                    items(currencies) { currency ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    bottomSheetNavigator.hide()
                                    onSelectCurrency(currency)
                                }
                                .padding(horizontal = 20.dp, vertical = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                modifier = Modifier.basicMarquee(),
                                text = "${currency.name?.getString()} (${currency.id})",
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1
                            )
                        }
                        Divider(modifier = Modifier.fillMaxWidth())
                    }
                }
            }
        }
    }
}
