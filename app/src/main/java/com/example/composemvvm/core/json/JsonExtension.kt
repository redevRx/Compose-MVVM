package com.example.composemvvm.core.json

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

internal inline fun <reified R : Any> String.toData() =
    Json {
        ignoreUnknownKeys = true
    }.decodeFromString<R>(this)