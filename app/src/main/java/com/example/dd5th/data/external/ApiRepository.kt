package com.example.dd5th.data.external

import com.example.dd5th.BuildConfig.BASE_URL
import com.example.dd5th.contract.EquipmentContract
import com.example.dd5th.contract.GenericResourceListingContract
import com.example.dd5th.contract.LanguageContract
import com.example.dd5th.contract.SpecificResourceListingContract
import com.example.dd5th.contract.AbilityScoreContract
import com.example.dd5th.contract.SkillContract
import com.example.dd5th.data.domain.ApiListResponse
import com.example.dd5th.data.domain.AbilityScore
import com.example.dd5th.data.domain.Skill
import com.example.dd5th.data.domain.Equipment
import com.example.dd5th.data.domain.Language
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRepository : GenericResourceListingContract.Api,
    SpecificResourceListingContract.Api,
    EquipmentContract.Api,
    LanguageContract.Api,
    AbilityScoreContract.Api,
    SkillContract.Api {

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
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<HashMap<String, String>>, t: Throwable) {
                    callback.onFailure()
                }
            }
            )
    }

    override fun listResourceItems(
        resourceName: String,
        callback: SpecificResourceListingContract.Callback
    ) {
        retrofit.listResourceItems(resourceName)
            .enqueue(object : Callback<ApiListResponse> {
                override fun onResponse(
                    call: Call<ApiListResponse>,
                    response: Response<ApiListResponse>
                ) {
                    if (response.isSuccessful) {
                        val apiList = response.body() as ApiListResponse
                        callback.onSuccess(apiList.results)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<ApiListResponse>, t: Throwable) {
                    callback.onFailure()
                }
            }

            )
    }

    override fun getAbilityScore(abilityName: String, callback: AbilityScoreContract.Callback) {
        retrofit.getAbilityScore(abilityName)
            .enqueue(object : Callback<AbilityScore> {
                override fun onResponse(
                    call: Call<AbilityScore>,
                    response: Response<AbilityScore>
                ) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body() as AbilityScore)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<AbilityScore>, t: Throwable) {
                    callback.onFailure()
                }
            })
    }

    override fun getEquipment(equipmentName: String, callback: EquipmentContract.Callback) {
        retrofit.getEquipment(equipmentName)
            .enqueue(object : Callback<Equipment> {
                override fun onResponse(call: Call<Equipment>, response: Response<Equipment>) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body() as Equipment)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<Equipment>, t: Throwable) {
                    callback.onFailure()
                }
            })
    }

    override fun getLanguage(languageName: String, callback: LanguageContract.Callback) {
        retrofit.getLanguage(languageName)
            .enqueue(object : Callback<Language> {
                override fun onResponse(call: Call<Language>, response: Response<Language>) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body() as Language)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<Language>, t: Throwable) {
                    callback.onFailure()
                }
            })
    }

    override fun getSkill(skillName: String, callback: SkillContract.Callback) {
        retrofit.getSkill(skillName)
            .enqueue(object : Callback<Skill> {
                override fun onResponse(call: Call<Skill>, response: Response<Skill>) {
                    if (response.isSuccessful) {
                        callback.onSuccess(response.body() as Skill)
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<Skill>, t: Throwable) {
                    callback.onFailure()
                }
            })
    }
}
