package com.example.dd5th.contract

import android.os.Bundle
import com.example.dd5th.data.domain.AbilityScore

interface AbilityScoreContract {

    interface View {
        fun showAbilityScore(abilityScore: AbilityScore)
    }

    interface Presenter {
        fun getAbilityScore(extras: Bundle?)
    }

    interface Callback {
        fun onSuccess(abilityScore: AbilityScore)
        fun onError()
        fun onFailure()
    }

    interface Api {
        fun getAbilityScore(abilityName: String, callback: Callback)
    }
}