package com.micudasoftware.currencyconverter.presentation.feature.currencyrates

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.micudasoftware.currencyconverter.SharedRes
import com.micudasoftware.currencyconverter.presentation.common.components.BottomNavigationBar
import com.micudasoftware.currencyconverter.presentation.common.components.Toolbar
import com.micudasoftware.currencyconverter.presentation.common.theme.CurrencyConverterTheme
import com.micudasoftware.currencyconverter.presentation.feature.currencyrates.model.CurrencyRatesState
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource

/**
 * The Simple screen to show latest currency rates.
 */
object CurrencyRatesScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<CurrencyRatesScreenModel>()
        val state by screenModel.state.collectAsState()

        Screen(viewState = state)
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun Screen(viewState: CurrencyRatesState) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { Toolbar(title = stringResource(SharedRes.strings.menu_all_currencies)) },
            bottomBar = { BottomNavigationBar(this) }
        ) { padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(CurrencyConverterTheme.colors.background)
                    ),
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                            .clickable {  },
                        colors = CardDefaults.cardColors(
                            containerColor = CurrencyConverterTheme.colors.primary
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(stringResource(SharedRes.strings.select_base_currency))
                            Icon(
                                painter = painterResource(SharedRes.images.ic_arrow_drop_down),
                                contentDescription = null
                            )
                        }
                    }
                    Card(modifier = Modifier.padding(vertical = 20.dp)) {
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(viewState.rates) { currencyRate ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 20.dp, vertical = 8.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        modifier = Modifier
                                            .padding(end = 8.dp)
                                            .weight(1f)
                                            .basicMarquee(),
                                        text = "${currencyRate.name?.let { stringResource(it) }} (${currencyRate.id})",
                                        overflow = TextOverflow.Ellipsis,
                                        maxLines = 1
                                    )
                                    Text(
                                        text = currencyRate.rate.toString(),
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Divider(modifier = Modifier.fillMaxWidth())
                            }
                        }
                    }
                }
            }
        }
    }
}