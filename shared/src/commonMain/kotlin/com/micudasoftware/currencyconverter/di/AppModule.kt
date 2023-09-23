package com.micudasoftware.currencyconverter.di

import com.micudasoftware.currencyconverter.data.api.CurrencyRatesApi
import com.micudasoftware.currencyconverter.data.api.common.ApiCaller
import com.micudasoftware.currencyconverter.data.repository.Repository
import com.micudasoftware.currencyconverter.data.repository.RepositoryImpl
import com.micudasoftware.currencyconverter.ui.viewmodel.CurrencyRatesScreenModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    singleOf(::ApiCaller)
    factoryOf(::CurrencyRatesApi)
    factoryOf(::RepositoryImpl) bind Repository::class
    factoryOf(::CurrencyRatesScreenModel)
}