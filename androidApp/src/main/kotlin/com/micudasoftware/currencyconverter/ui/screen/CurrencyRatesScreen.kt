package com.micudasoftware.currencyconverter.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.micudasoftware.currencyconverter.data.repository.model.Currency

/**
 * The Simple screen to show latest currency rates.
 *
 * @param viewState The view state.
 */
@Composable
fun CurrencyRatesScreen(
    viewState: State<CurrencyRatesState>,
) {
    val state by viewState

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

/**
 * Preview for [CurrencyRatesScreen]
 */
@Preview
@Composable
private fun CurrencyRatesScreenPreview() {
    MaterialTheme {
        CurrencyRatesScreen(
            viewState = remember {
                mutableStateOf(
                    CurrencyRatesState(
                        listOf(
                            Currency("SDF", 1.6),
                            Currency("GBR", 2.7),
                            Currency("FGH", 3.8),
                            Currency("IUY", 4.9),
                        )
                    )
                )
            }
        )
    }
}
