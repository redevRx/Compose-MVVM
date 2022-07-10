package com.example.composemvvm.core.genaricType

data class ResultLists(
    val createDate: String,
    val descriptionEn: String,
    val descriptionTh: String,
    val enable: Boolean,
    val id: Int,
    val name: String,
    val platformDatails: List<PlatformDatail>,
    val posterUrl: String,
    val thumbnailUrl: String,
    val updateDate: String
)