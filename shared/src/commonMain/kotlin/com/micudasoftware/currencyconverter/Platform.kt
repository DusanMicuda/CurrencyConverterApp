package com.micudasoftware.currencyconverter

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform