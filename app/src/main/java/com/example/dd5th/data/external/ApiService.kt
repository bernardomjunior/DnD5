package com.example.dd5th.data.external

import com.example.dd5th.data.domain.AbilityScore
import com.example.dd5th.data.domain.ApiListResponse
import com.example.dd5th.data.domain.DamageType
import com.example.dd5th.data.domain.Equipment
import com.example.dd5th.data.domain.Language
import com.example.dd5th.data.domain.Monster
import com.example.dd5th.data.domain.Skill
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/")
    fun listApiOptions(): Call<HashMap<String, String>>

    @GET("api/{resource}/")
    fun listResourceItems(
        @Path("resource") resource: String
    ): Call<ApiListResponse>

    @GET("api/monsters/{monsterName}")
    fun getMonster(
        @Path("monsterName") resource: String
    ): Call<Monster>

    @GET("api/equipment/{equipmentName}")
    fun getEquipment(
        @Path("equipmentName") equipmentName: String
    ): Call<Equipment>

    @GET("api/languages/{languageName}")
    fun getLanguage(
        @Path("languageName") languageName: String
    ): Call<Language>

    @GET("/api/ability-scores/{abilityScore}")
    fun getAbilityScore(
        @Path("abilityScore") abilityName: String
    ): Call<AbilityScore>

    @GET("/api/skills/{skill}")
    fun getSkill(
        @Path("skill") skill: String
    ): Call<Skill>

    @GET("/api/damage-types/{damageName}")
    fun getDamageType(
        @Path("damageName") damageName: String
    ): Call<DamageType>

}