package com.micudasoftware.currencyconverter.di

import com.micudasoftware.currencyconverter.data.api.common.ApiCaller
import com.micudasoftware.currencyconverter.data.api.currencyRatesApi.CurrencyRatesApi
import com.micudasoftware.currencyconverter.data.api.getCurrenciesApi.GetCurrenciesApi
import com.micudasoftware.currencyconverter.data.repository.Repository
import com.micudasoftware.currencyconverter.data.repository.RepositoryImpl
import com.micudasoftware.currencyconverter.presentation.feature.currencyconverter.CurrencyConverterScreenModel
import com.micudasoftware.currencyconverter.presentation.feature.currencyrates.CurrencyRatesScreenModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    singleOf(::ApiCaller)
    factoryOf(::CurrencyRatesApi)
    factoryOf(::GetCurrenciesApi)
    factoryOf(::RepositoryImpl) bind Repository::class
    factoryOf(::CurrencyRatesScreenModel)
    factoryOf(::CurrencyConverterScreenModel)
}