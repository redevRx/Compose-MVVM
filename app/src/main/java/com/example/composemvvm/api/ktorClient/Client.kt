package com.example.composemvvm.api.ktorClient

import android.util.Log
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

open class Client {
    companion object {
        private val json = Json {  }

        inline fun build(): HttpClient{
            return HttpClient(Android){
                install(Logging){
                    logger = object : Logger {
                        override fun log(message: String) {
                            Log.v("Logger Ktor ->", message)
                        }

                    }
                    level = LogLevel.ALL
                }

                install(HttpTimeout){
                    val timeout = 60_000L
                    socketTimeoutMillis = timeout
                    requestTimeoutMillis = timeout
                    connectTimeoutMillis = timeout
                }
            }
        }
    }
}
