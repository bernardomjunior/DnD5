package com.example.dd5th.data.domain

data class Monster(
    val name: String,
    val size: String,
    val type: String,
    val subtype: String?,
    val alignment: String,
    val armor_class: Int,
    val hitPoints: Int,
    val hitDice: String,
    val speed: Speed,
    val strength: Int,
    val dexterity: Int,
    val constitution: Int,
    val intelligence: Int,
    val wisdom: Int,
    val charisma: Int,
    val proficiencies: ArrayList<ApiListItemResponse>,
    val damageImmunities: ArrayList<String>,
    val languages: String,
    val challengeRatting: Int
)