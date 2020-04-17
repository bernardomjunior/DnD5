package com.example.dd5th.data.external

import com.example.dd5th.ui.activity.HomeActivity
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiOptionsRepository(
    private val homeActivity: HomeActivity
) {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://www.dnd5eapi.co")
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().create()
            )
        )
        .build()
        .create(ApiOptionsService::class.java)

    fun listApiOptions() {
        retrofit.listApiOptions()
            .enqueue(object : Callback<HashMap<String, String>> {
                override fun onResponse(
                    call: Call<HashMap<String, String>>,
                    response: Response<HashMap<String, String>>
                ) {
                    if (response.isSuccessful) {
                        homeActivity.upDateOptionList(response.body() as HashMap<String, String>)
                    }
                }

                override fun onFailure(call: Call<HashMap<String, String>>, t: Throwable) {

                }
            }
            )
    }

}
