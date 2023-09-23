package com.micudasoftware.currencyconverter.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.micudasoftware.currencyconverter.ui.viewmodel.CurrencyRatesScreenModel

/**
 * The Simple screen to show latest currency rates.
 */
object CurrencyRatesScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<CurrencyRatesScreenModel>()
        val state by screenModel.state.collectAsState()

        Scaffold(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(it)
            ) {
                items(state.rates) { currencyRate ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = currencyRate.id)
                        Text(text = currencyRate.rate.toString())
                    }
                    Divider(modifier = Modifier.fillMaxWidth())
                }
            }
        }
    }
}