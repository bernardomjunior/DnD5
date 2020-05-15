package com.example.dd5th.data.domain

import com.google.gson.annotations.SerializedName

data class DamageType (
    val index: String,
    val name: String,
    @SerializedName("desc")
    val description: List<String>,
    val url: String
)