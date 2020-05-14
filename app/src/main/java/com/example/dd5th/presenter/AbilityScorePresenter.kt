package com.example.dd5th.presenter

import android.os.Bundle
import com.example.dd5th.contract.AbilityScoreContract
import com.example.dd5th.data.domain.AbilityScore
import com.example.dd5th.data.domain.ApiListItemResponse
import com.example.dd5th.data.external.ApiRepository

class AbilityScorePresenter(
    private val view: AbilityScoreContract.View
): AbilityScoreContract.Presenter, AbilityScoreContract.Callback {

    private val api: AbilityScoreContract.Api = ApiRepository()

    override fun getAbilityScore(extras: Bundle?) {
        extras?.let { e ->
            e.getString(ABILITY_SCORES)?.let {
                api.getAbilityScore(it, this)
            }
        }
    }

    override fun onSuccess(abilityScore: AbilityScore) {
        val newAbilityScore = AbilityScore(
            abilityScore.name,
            abilityScore.fullName,
            abilityScore.description,
        abilityScore.skills.map { ApiListItemResponse(
            getIndexFromUrl(it.url), it.name, it.url
        ) })
        view.showAbilityScore(newAbilityScore)
    }

    private fun getIndexFromUrl(url: String): String{
        return url.split("/").last()
    }

    override fun onError() {
        TODO("Not yet implemented")
    }

    override fun onFailure() {
        TODO("Not yet implemented")
    }
}