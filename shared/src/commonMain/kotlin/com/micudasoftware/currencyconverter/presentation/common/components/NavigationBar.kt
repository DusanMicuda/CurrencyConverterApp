package com.micudasoftware.currencyconverter.presentation.common.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.micudasoftware.currencyconverter.SharedRes
import com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.CurrencyConverterScreen
import com.micudasoftware.currencyconverter.presentation.feature.currencyrates.CurrencyRatesScreen
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

/**
 * Bottom navigation bar.
 *
 * @param tabNavigator [TabNavigator] used to navigate between tabs.
 */
@Composable
fun BottomNavigationBar(
    tabNavigator: TabNavigator?
) {
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
            selected = tabNavigator?.current is CurrencyConverterScreen,
            onClick = { tabNavigator?.current = CurrencyConverterScreen() }
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
            selected = tabNavigator?.current is CurrencyRatesScreen,
            onClick = { tabNavigator?.current = CurrencyRatesScreen() }
        )
    }
}
