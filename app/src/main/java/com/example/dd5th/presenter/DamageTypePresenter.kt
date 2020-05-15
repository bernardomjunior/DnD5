package com.example.dd5th.presenter

import com.example.dd5th.contract.DamageTypeContract
import com.example.dd5th.data.domain.DamageType
import com.example.dd5th.data.external.ApiRepository

class DamageTypePresenter(
    private val view: DamageTypeContract.View
): DamageTypeContract.Callback, DamageTypeContract.Presenter {

    private val api: DamageTypeContract.Api = ApiRepository

    override fun getDamageType(damageName: String?) {
        damageName?.let {
            api.getDamageType(it, this)
        }
    }

    override fun onSuccess(damageType: DamageType) {
        view.onDamageTypeResult(damageType)
    }

    override fun onError() {
        TODO("Not yet implemented")
    }

    override fun onFailure() {
        TODO("Not yet implemented")
    }

}