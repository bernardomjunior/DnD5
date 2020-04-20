package com.example.dd5th.data.domain

data class Equipment (
    val index: String,
    val name: String,
    val equipmentCategory: String,
    val gearCategory: String,
    val cost: Cost,
    val weight: Int
)