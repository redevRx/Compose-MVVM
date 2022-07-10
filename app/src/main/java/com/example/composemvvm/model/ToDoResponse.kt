package com.example.composemvvm.model

import kotlinx.serialization.Serializable

@Serializable
data class ToDoResponse(
    val completed: Boolean = false,
    val id: Int = 0,
    val title: String = "",
    val userId: Int = 0)


@Serializable
data class Data(val text: String, val age: Int)