package com.example.dd5th.presenter

import android.os.Bundle
import com.example.dd5th.contract.AbilityScoreContract
import com.example.dd5th.data.domain.AbilityScore
import com.example.dd5th.data.external.ApiRepository
import com.example.dd5th.util.ABILITY_SCORES

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
        view.showAbilityScore(abilityScore)
    }

    override fun onError() {
        TODO("Not yet implemented")
    }

    override fun onFailure() {
        TODO("Not yet implemented")
    }
}