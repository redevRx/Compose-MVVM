package com.example.composemvvm.core.genaricType

data class Text(
    val allRecord: Int,
    val currentPage: Int,
    val getAllRecord: Boolean,
    val recordEnd: Int,
    val recordPerPage: Int,
    val recordStart: Int,
    val resultLists: List<ResultLists>,
    val totalPage: Int
)