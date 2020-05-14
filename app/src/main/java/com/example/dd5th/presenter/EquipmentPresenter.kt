package com.example.dd5th.presenter

import android.os.Bundle
import com.example.dd5th.contract.EquipmentContract
import com.example.dd5th.data.domain.Equipment
import com.example.dd5th.data.external.ApiRepository
import com.example.dd5th.presenter.Constants.Companion.EQUIPMENT

class EquipmentPresenter(
    private val view: EquipmentContract.View
) : EquipmentContract.Presenter, EquipmentContract.Callback {

    private val api: EquipmentContract.Api = ApiRepository

    override fun getEquipmentIfExtra(extras: Bundle?) {
        extras?.let { e ->
            e.getString(EQUIPMENT)?.let {
                api.getEquipment(it, this)
            }
        }
    }

    override fun onSuccess(equipment: Equipment) {
        view.showEquipment(equipment)
    }

    override fun onError() {
        TODO("Not yet implemented")
    }

    override fun onFailure() {
        TODO("Not yet implemented")
    }
}