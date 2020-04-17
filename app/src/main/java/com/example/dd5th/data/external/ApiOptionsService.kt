package com.example.dd5th.data.external

import retrofit2.Call
import retrofit2.http.GET

interface ApiOptionsService {

    @GET("api/")
    fun listApiOptions(): Call<HashMap<String, String>>

}