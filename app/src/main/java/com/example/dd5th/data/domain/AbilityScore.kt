package com.example.dd5th.data.domain

import com.google.gson.annotations.SerializedName

data class AbilityScore(
    val name: String,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("desc")
    val description: List<String>,
    val skills: List<ApiListItemResponse>
)