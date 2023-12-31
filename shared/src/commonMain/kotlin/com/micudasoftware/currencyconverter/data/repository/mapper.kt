package com.micudasoftware.currencyconverter.data.repository

import com.micudasoftware.currencyconverter.SharedRes
import com.micudasoftware.currencyconverter.data.api.currencyRatesApi.model.CurrencyRatesResDto
import com.micudasoftware.currencyconverter.data.api.getCurrenciesApi.model.CurrencyDto
import com.micudasoftware.currencyconverter.data.repository.model.Currency
import com.micudasoftware.currencyconverter.data.repository.model.CurrencyRate
import dev.icerock.moko.resources.desc.desc
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject

/**
 * Function to map [CurrencyRatesResDto] to list of [CurrencyRate].
 *
 * @return A [List] of [CurrencyRate].
 */
fun CurrencyRatesResDto.toCurrencyRateList(): List<CurrencyRate> {
    val jsonElement = Json.encodeToJsonElement(this.rates)
    return jsonElement.jsonObject.mapNotNull { property ->
        property.value.toString().toDoubleOrNull()?.let {
            CurrencyRate(id = property.key, rate = it, name = getFullCurrencyName(property.key))
        }
    }
}

/**
 * Function to map [CurrencyDto] to list of [Currency].
 *
 * @return A [List] of [Currency].
 */
fun CurrencyDto.toCurrencyList(): List<Currency> {
    val jsonElement = Json.encodeToJsonElement(this)
    return jsonElement.jsonObject.mapNotNull { property ->
        Currency(id = property.key, name = getFullCurrencyName(property.key))
    }
}

/**
 * Function to map 3-letter currency code to string resource full name.
 *
 * @param currencyId A 3-letter currency code.
 */
fun getFullCurrencyName(currencyId: String) =
    when (currencyId) {
        "AFN" -> SharedRes.strings.currency_afn
        "AED" -> SharedRes.strings.currency_aed
        "ALL" -> SharedRes.strings.currency_all
        "AMD" -> SharedRes.strings.currency_amd
        "ANG" -> SharedRes.strings.currency_ang
        "AOA" -> SharedRes.strings.currency_aoa
        "ARS" -> SharedRes.strings.currency_ars
        "AUD" -> SharedRes.strings.currency_aud
        "AWG" -> SharedRes.strings.currency_awg
        "AZN" -> SharedRes.strings.currency_azn
        "BAM" -> SharedRes.strings.currency_bam
        "BBD" -> SharedRes.strings.currency_bbd
        "BDT" -> SharedRes.strings.currency_bdt
        "BGN" -> SharedRes.strings.currency_bgn
        "BHD" -> SharedRes.strings.currency_bhd
        "BIF" -> SharedRes.strings.currency_bif
        "BMD" -> SharedRes.strings.currency_bmd
        "BND" -> SharedRes.strings.currency_bnd
        "BOB" -> SharedRes.strings.currency_bob
        "BRL" -> SharedRes.strings.currency_brl
        "BSD" -> SharedRes.strings.currency_bsd
        "BTC" -> SharedRes.strings.currency_btc
        "BTN" -> SharedRes.strings.currency_btn
        "BWP" -> SharedRes.strings.currency_bwp
        "BYN" -> SharedRes.strings.currency_byn
        "BZD" -> SharedRes.strings.currency_bzd
        "CAD" -> SharedRes.strings.currency_cad
        "CDF" -> SharedRes.strings.currency_cdf
        "CHF" -> SharedRes.strings.currency_chf
        "CLF" -> SharedRes.strings.currency_clf
        "CLP" -> SharedRes.strings.currency_clp
        "CNH" -> SharedRes.strings.currency_cnh
        "CNY" -> SharedRes.strings.currency_cny
        "COP" -> SharedRes.strings.currency_cop
        "CRC" -> SharedRes.strings.currency_crc
        "CUC" -> SharedRes.strings.currency_cuc
        "CUP" -> SharedRes.strings.currency_cup
        "CVE" -> SharedRes.strings.currency_cve
        "CZK" -> SharedRes.strings.currency_czk
        "DJF" -> SharedRes.strings.currency_djf
        "DKK" -> SharedRes.strings.currency_dkk
        "DOP" -> SharedRes.strings.currency_dop
        "DZD" -> SharedRes.strings.currency_dzd
        "EGP" -> SharedRes.strings.currency_egp
        "ERN" -> SharedRes.strings.currency_ern
        "ETB" -> SharedRes.strings.currency_etb
        "EUR" -> SharedRes.strings.currency_eur
        "FJD" -> SharedRes.strings.currency_fjd
        "FKP" -> SharedRes.strings.currency_fkp
        "GBP" -> SharedRes.strings.currency_gbp
        "GEL" -> SharedRes.strings.currency_gel
        "GGP" -> SharedRes.strings.currency_ggp
        "GHS" -> SharedRes.strings.currency_ghs
        "GIP" -> SharedRes.strings.currency_gip
        "GMD" -> SharedRes.strings.currency_gmd
        "GNF" -> SharedRes.strings.currency_gnf
        "GTQ" -> SharedRes.strings.currency_gtq
        "GYD" -> SharedRes.strings.currency_gyd
        "HKD" -> SharedRes.strings.currency_hkd
        "HNL" -> SharedRes.strings.currency_hnl
        "HRK" -> SharedRes.strings.currency_hrk
        "HTG" -> SharedRes.strings.currency_htg
        "HUF" -> SharedRes.strings.currency_huf
        "IDR" -> SharedRes.strings.currency_idr
        "ILS" -> SharedRes.strings.currency_ils
        "IMP" -> SharedRes.strings.currency_imp
        "INR" -> SharedRes.strings.currency_inr
        "IQD" -> SharedRes.strings.currency_iqd
        "IRR" -> SharedRes.strings.currency_irr
        "ISK" -> SharedRes.strings.currency_isk
        "JEP" -> SharedRes.strings.currency_jep
        "JMD" -> SharedRes.strings.currency_jmd
        "JOD" -> SharedRes.strings.currency_jod
        "JPY" -> SharedRes.strings.currency_jpy
        "KES" -> SharedRes.strings.currency_kes
        "KGS" -> SharedRes.strings.currency_kgs
        "KHR" -> SharedRes.strings.currency_khr
        "KMF" -> SharedRes.strings.currency_kmf
        "KPW" -> SharedRes.strings.currency_kpw
        "KRW" -> SharedRes.strings.currency_krw
        "KWD" -> SharedRes.strings.currency_kwd
        "KYD" -> SharedRes.strings.currency_kyd
        "KZT" -> SharedRes.strings.currency_kzt
        "LAK" -> SharedRes.strings.currency_lak
        "LBP" -> SharedRes.strings.currency_lbp
        "LKR" -> SharedRes.strings.currency_lkr
        "LRD" -> SharedRes.strings.currency_lrd
        "LSL" -> SharedRes.strings.currency_lsl
        "LYD" -> SharedRes.strings.currency_lyd
        "MAD" -> SharedRes.strings.currency_mad
        "MDL" -> SharedRes.strings.currency_mdl
        "MGA" -> SharedRes.strings.currency_mga
        "MKD" -> SharedRes.strings.currency_mkd
        "MMK" -> SharedRes.strings.currency_mmk
        "MNT" -> SharedRes.strings.currency_mnt
        "MOP" -> SharedRes.strings.currency_mop
        "MRU" -> SharedRes.strings.currency_mru
        "MUR" -> SharedRes.strings.currency_mur
        "MVR" -> SharedRes.strings.currency_mvr
        "MWK" -> SharedRes.strings.currency_mwk
        "MXN" -> SharedRes.strings.currency_mxn
        "MYR" -> SharedRes.strings.currency_myr
        "MZN" -> SharedRes.strings.currency_mzn
        "NAD" -> SharedRes.strings.currency_nad
        "NGN" -> SharedRes.strings.currency_ngn
        "NIO" -> SharedRes.strings.currency_nio
        "NOK" -> SharedRes.strings.currency_nok
        "NPR" -> SharedRes.strings.currency_npr
        "NZD" -> SharedRes.strings.currency_nzd
        "OMR" -> SharedRes.strings.currency_omr
        "PAB" -> SharedRes.strings.currency_pab
        "PEN" -> SharedRes.strings.currency_pen
        "PGK" -> SharedRes.strings.currency_pgk
        "PHP" -> SharedRes.strings.currency_php
        "PKR" -> SharedRes.strings.currency_pkr
        "PLN" -> SharedRes.strings.currency_pln
        "PYG" -> SharedRes.strings.currency_pyg
        "QAR" -> SharedRes.strings.currency_qar
        "RON" -> SharedRes.strings.currency_ron
        "RSD" -> SharedRes.strings.currency_rsd
        "RUB" -> SharedRes.strings.currency_rub
        "RWF" -> SharedRes.strings.currency_rwf
        "SAR" -> SharedRes.strings.currency_sar
        "SBD" -> SharedRes.strings.currency_sbd
        "SCR" -> SharedRes.strings.currency_scr
        "SDG" -> SharedRes.strings.currency_sdg
        "SEK" -> SharedRes.strings.currency_sek
        "SGD" -> SharedRes.strings.currency_sgd
        "SHP" -> SharedRes.strings.currency_shp
        "SLL" -> SharedRes.strings.currency_sll
        "SOS" -> SharedRes.strings.currency_sos
        "SRD" -> SharedRes.strings.currency_srd
        "SSP" -> SharedRes.strings.currency_ssp
        "STD" -> SharedRes.strings.currency_std
        "STN" -> SharedRes.strings.currency_stn
        "SVC" -> SharedRes.strings.currency_svc
        "SYP" -> SharedRes.strings.currency_syp
        "SZL" -> SharedRes.strings.currency_szl
        "THB" -> SharedRes.strings.currency_thb
        "TJS" -> SharedRes.strings.currency_tjs
        "TMT" -> SharedRes.strings.currency_tmt
        "TND" -> SharedRes.strings.currency_tnd
        "TOP" -> SharedRes.strings.currency_top
        "TRY" -> SharedRes.strings.currency_try
        "TTD" -> SharedRes.strings.currency_ttd
        "TWD" -> SharedRes.strings.currency_twd
        "TZS" -> SharedRes.strings.currency_tzs
        "UAH" -> SharedRes.strings.currency_uah
        "UGX" -> SharedRes.strings.currency_ugx
        "USD" -> SharedRes.strings.currency_usd
        "UYU" -> SharedRes.strings.currency_uyu
        "UZS" -> SharedRes.strings.currency_uzs
        "VES" -> SharedRes.strings.currency_ves
        "VND" -> SharedRes.strings.currency_vnd
        "VUV" -> SharedRes.strings.currency_vuv
        "WST" -> SharedRes.strings.currency_wst
        "XAF" -> SharedRes.strings.currency_xaf
        "XAG" -> SharedRes.strings.currency_xag
        "XAU" -> SharedRes.strings.currency_xau
        "XCD" -> SharedRes.strings.currency_xcd
        "XDR" -> SharedRes.strings.currency_xdr
        "XOF" -> SharedRes.strings.currency_xof
        "XPD" -> SharedRes.strings.currency_xpd
        "XPF" -> SharedRes.strings.currency_xpf
        "XPT" -> SharedRes.strings.currency_xpt
        "YER" -> SharedRes.strings.currency_yer
        "ZAR" -> SharedRes.strings.currency_zar
        "ZMW" -> SharedRes.strings.currency_zmw
        "ZWL" -> SharedRes.strings.currency_zwl
        else -> null
    }?.desc()