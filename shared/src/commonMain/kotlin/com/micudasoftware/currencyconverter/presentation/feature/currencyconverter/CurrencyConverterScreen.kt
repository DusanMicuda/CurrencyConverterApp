package com.micudasoftware.currencyconverter.presentation.feature.currencyconverter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.micudasoftware.currencyconverter.SharedRes
import com.micudasoftware.currencyconverter.presentation.common.components.BlockingLoader
import com.micudasoftware.currencyconverter.presentation.common.components.BottomNavigationBar
import com.micudasoftware.currencyconverter.presentation.common.components.CurrencySelectorBottomSheet
import com.micudasoftware.currencyconverter.presentation.common.components.CustomOutlinedTextField
import com.micudasoftware.currencyconverter.presentation.common.components.GenericDialog
import com.micudasoftware.currencyconverter.presentation.common.components.Toolbar
import com.micudasoftware.currencyconverter.presentation.common.getString
import com.micudasoftware.currencyconverter.presentation.common.model.LoadingModel
import com.micudasoftware.currencyconverter.presentation.common.theme.CurrencyConverterTheme
import com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.model.CurrencyConverterEvent
import com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.model.CurrencyConverterState
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import dev.icerock.moko.resources.desc.desc

/**
 * Screen for converting currencies.
 */
class CurrencyConverterScreen : Tab {


    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(SharedRes.strings.app_name)
            return remember {
                TabOptions(
                    index = 0U,
                    title = title,
                )
            }
        }

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<CurrencyConverterScreenModel>()
        val viewState by screenModel.state.collectAsState()

        Screen(viewState = viewState, onEvent = { screenModel.onEvent(it) })
    }

    @Composable
    fun Screen(
        viewState: CurrencyConverterState,
        onEvent: (CurrencyConverterEvent) -> Unit
    ) {
        val bottomSheetNavigator = LocalBottomSheetNavigator.current

        when {
            viewState.loadingModel is LoadingModel.Blocking -> BlockingLoader()
            viewState.dialogModel != null -> GenericDialog(viewState.dialogModel)
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { Toolbar(title = stringResource(SharedRes.strings.app_name)) },
            bottomBar = { BottomNavigationBar() }
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(CurrencyConverterTheme.colors.background)
                    ),
            ) {
                Card(
                    modifier = Modifier
                        .padding(top = 48.dp)
                        .padding(horizontal = 20.dp),
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CustomOutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = viewState.fromCurrency.value,
                            label = SharedRes.strings.currency_value_label.desc(),
                            errorText = viewState.fromCurrency.valueError,
                            onValueChange = {
                                onEvent(
                                    CurrencyConverterEvent.UpdateCurrencyToConvertValue(
                                        it
                                    )
                                )
                            },
                        )
                        CustomOutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            value = viewState.fromCurrency.currency?.name?.getString() ?: "",
                            label = SharedRes.strings.currency_label.desc(),
                            errorText = viewState.fromCurrency.currencyError,
                            readOnly = true,
                            onClick = {
                                bottomSheetNavigator.show(
                                    CurrencySelectorBottomSheet(
                                        currencies = viewState.currencies,
                                        onSelectCurrency = {
                                            onEvent(
                                                CurrencyConverterEvent
                                                    .OnSelectFromCurrency(it)
                                            )
                                        }
                                    )
                                )
                            },
                            onValueChange = {},
                        )
                        IconButton(
                            modifier = Modifier.padding(top = 8.dp),
                            onClick = { onEvent(CurrencyConverterEvent.TurnCurrencies) }
                        ) {
                            Icon(
                                painter = painterResource(SharedRes.images.ic_swap_vert),
                                contentDescription = null
                            )
                        }
                        CustomOutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            value = viewState.toCurrency.value,
                            label = SharedRes.strings.currency_value_label.desc(),
                            readOnly = true,
                            onValueChange = {},
                        )
                        CustomOutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            value = viewState.toCurrency.currency?.name?.getString() ?: "",
                            label = SharedRes.strings.currency_label.desc(),
                            errorText = viewState.toCurrency.currencyError,
                            readOnly = true,
                            onClick = {
                                bottomSheetNavigator.show(
                                    CurrencySelectorBottomSheet(
                                        currencies = viewState.currencies,
                                        onSelectCurrency = {
                                            onEvent(
                                                CurrencyConverterEvent
                                                    .OnSelectToCurrency(it)
                                            )
                                        }
                                    )
                                )
                            },
                            onValueChange = {},
                        )
                        Button(
                            modifier = Modifier.padding(top = 16.dp),
                            enabled = viewState.isFormValid,
                            onClick = { onEvent(CurrencyConverterEvent.ConvertCurrency) }
                        ) {
                            if (viewState.loadingModel is LoadingModel.Local) {
                                CircularProgressIndicator(
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .size(24.dp),
                                    color = Color.White
                                )
                            } else {
                                Text(
                                    modifier = Modifier.padding(8.dp),
                                    text = stringResource(SharedRes.strings.button_convert)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
