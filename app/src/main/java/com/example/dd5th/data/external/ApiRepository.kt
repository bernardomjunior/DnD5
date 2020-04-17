package com.example.dd5th.data.external

import androidx.appcompat.app.AppCompatActivity
import com.example.dd5th.BuildConfig.BASE_URL
import com.example.dd5th.data.domain.ApiListResponse
import com.example.dd5th.ui.activity.HomeActivity
import com.example.dd5th.ui.activity.ResourceListActivity
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().create()
            )
        )
        .build()
        .create(ApiService::class.java)

    fun listApiOptions(homeActivity: HomeActivity) {
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
                    TODO("Not yet implemented")
                }
            }
            )
    }

    fun listResourceItems(resourceName: String, activity: ResourceListActivity){
        retrofit.listResourceItems(resourceName)
            .enqueue( object : Callback<ApiListResponse>{
                override fun onResponse(
                    call: Call<ApiListResponse>,
                    response: Response<ApiListResponse>
                ) {
                    if (response.isSuccessful){
                        val apiList = response.body() as ApiListResponse
                        activity.updateList(apiList.results)
                    }
                }

                override fun onFailure(call: Call<ApiListResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            }

            )
    }

}
