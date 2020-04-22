package com.example.dd5th.data.external

import com.example.dd5th.data.domain.ApiListResponse
import com.example.dd5th.data.domain.Equipment
import com.example.dd5th.data.domain.Monster
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

}