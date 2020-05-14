package com.example.dd5th.data.domain

import com.google.gson.annotations.SerializedName

data class Skill (
    val index: String,
    val name: String,
    @SerializedName("desc")
    val description: List<String>,
    @SerializedName("ability_score")
    val abilityScoreApiItem: ApiListItemResponse)