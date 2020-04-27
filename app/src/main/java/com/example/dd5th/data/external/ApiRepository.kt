package com.example.dd5th.data.external

import android.util.Log
import com.example.dd5th.BuildConfig.BASE_URL
import com.example.dd5th.contract.GenericResourceListingContract
import com.example.dd5th.contract.SpecificResourceListingContract
import com.example.dd5th.data.domain.ApiListResponse
import com.example.dd5th.data.domain.Equipment
import com.example.dd5th.data.domain.Language
import com.example.dd5th.ui.activity.EquipmentActivity
import com.example.dd5th.ui.activity.LanguagesActivity
import com.example.dd5th.ui.activity.SpecificResourceListActivity
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRepository : GenericResourceListingContract.Api, SpecificResourceListingContract.Api{

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().create()
            )
        )
        .build()
        .create(ApiService::class.java)

    override fun listApiOptions(callback: GenericResourceListingContract.Callback) {
        retrofit.listApiOptions()
            .enqueue(object : Callback<HashMap<String, String>> {
                override fun onResponse(
                    call: Call<HashMap<String, String>>,
                    response: Response<HashMap<String, String>>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body() as HashMap<String, String>)
                    }
                }

                override fun onFailure(call: Call<HashMap<String, String>>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            }
            )
    }

    override fun listResourceItems(resourceName: String, callback: SpecificResourceListingContract.Callback) {
        retrofit.listResourceItems(resourceName)
            .enqueue(object : Callback<ApiListResponse> {
                override fun onResponse(
                    call: Call<ApiListResponse>,
                    response: Response<ApiListResponse>
                ) {
                    if (response.isSuccessful) {
                        val apiList = response.body() as ApiListResponse
                        callback.onSuccess(apiList.results)
                        Log.w("Specific listing", resourceName + " 2")

                    }
                }

                override fun onFailure(call: Call<ApiListResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            }

            )
    }

    fun getEquipment(equipmentName: String, activity: EquipmentActivity){
        retrofit.getEquipment(equipmentName)
            .enqueue(object : Callback<Equipment>{
                override fun onResponse(call: Call<Equipment>, response: Response<Equipment>) {
                    if (response.isSuccessful){
                        activity.onEquipmentResult(response.body() as Equipment)
                    }
                }

                override fun onFailure(call: Call<Equipment>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
    }

    fun getLanguage(languageName: String, activity: LanguagesActivity){
        retrofit.getLanguage(languageName)
            .enqueue(object : Callback<Language>{
                override fun onResponse(call: Call<Language>, response: Response<Language>) {
                    if (response.isSuccessful){
                        activity.onLanguageResult(response.body() as Language)
                    }
                }

                override fun onFailure(call: Call<Language>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
    }

}
