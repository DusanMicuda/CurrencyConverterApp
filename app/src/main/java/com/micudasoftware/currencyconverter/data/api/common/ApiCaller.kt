package com.micudasoftware.currencyconverter.data.api.common

import com.micudasoftware.currencyconverter.common.model.Result
import com.micudasoftware.currencyconverter.common.model.toSuccess
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.security.SecureRandom
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext

class ApiCaller {

    val client: HttpClient = HttpClient(Android) {
        expectSuccess = true
        install(ContentNegotiation) {
            json(
                Json { ignoreUnknownKeys = true }
            )
        }
        install(Logging) {
            level = LogLevel.ALL
        }
        engine {
            sslManager = {
                val sslContext = SSLContext.getInstance("TLS")
                sslContext.init(
                    null,
                    null,
                    SecureRandom()
                )
                it.sslSocketFactory = sslContext.socketFactory
                it.hostnameVerifier = HostnameVerifier { hostname, _ ->
                    hostname.startsWith("api.exchangerate.host")
                }
            }
        }
    }

    suspend inline fun <reified T : Any> callResult(
        url: String,
        request: Any,
    ): Result<T> = withContext(Dispatchers.IO){
        var response: HttpResponse? = null
        return@withContext try {
            response = client.get(url) {
                url { parameters.appendAll(request) }
            }
            response.body<T>().toSuccess()
        } catch (e: Exception) {
            println("${response?.status} - ${e.message}")
            Result.Error()
        }
    }
}
