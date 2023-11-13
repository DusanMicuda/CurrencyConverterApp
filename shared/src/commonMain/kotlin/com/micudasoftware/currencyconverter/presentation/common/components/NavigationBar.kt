package com.micudasoftware.currencyconverter.presentation.common.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import com.micudasoftware.currencyconverter.SharedRes
import com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.CurrencyConverterScreen
import com.micudasoftware.currencyconverter.presentation.feature.currencyrates.CurrencyRatesScreen
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

/**
 * Bottom navigation bar.
 */
@Composable
fun BottomNavigationBar() {
    val navigator = LocalTabNavigator.current

    NavigationBar(
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            label = {
                Text(text = stringResource(SharedRes.strings.menu_converter))
            },
            icon = {
                Icon(
                    painterResource(SharedRes.images.ic_currency_exchange),
                    contentDescription = null
                )
            },
            selected = navigator.current is CurrencyConverterScreen,
            onClick = { navigator.current = CurrencyConverterScreen() }
        )
        NavigationBarItem(
            label = {
                Text(text = stringResource(SharedRes.strings.menu_all_currencies))
            },
            icon = {
                Icon(
                    painterResource(SharedRes.images.ic_payments),
                    contentDescription = null
                )
            },
            selected = navigator.current is CurrencyRatesScreen,
            onClick = { navigator.current = CurrencyRatesScreen() }
        )
    }
}
