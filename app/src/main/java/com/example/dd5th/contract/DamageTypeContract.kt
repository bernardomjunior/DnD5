package com.example.dd5th.contract

import com.example.dd5th.data.domain.DamageType

interface DamageTypeContract {

    interface View {
        fun onDamageTypeResult(damageType: DamageType)
    }

    interface Presenter {
        fun getDamageType(damageName: String?)
        fun listToText(description: List<String>): String
    }

    interface Callback {
        fun onSuccess(damageType: DamageType)
        fun onError()
        fun onFailure()
    }

    interface Api {
        fun getDamageType(damageName: String, callback: Callback)
    }

}