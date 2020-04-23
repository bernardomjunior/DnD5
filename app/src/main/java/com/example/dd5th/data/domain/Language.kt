package com.example.dd5th.data.domain

import com.google.gson.annotations.SerializedName

data class Language (
    val name: String,
    val type: String,
    @SerializedName("typical_speakers")
    val typicalSpeakers: ArrayList<String>,
    val script: String
)