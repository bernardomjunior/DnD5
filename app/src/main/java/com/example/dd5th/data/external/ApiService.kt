package com.example.dd5th.data.external

import com.example.dd5th.data.domain.*
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

}