package com.example.dd5th.contract

import com.example.dd5th.data.domain.Equipment

interface EquipmentContract {

    interface View {
        fun showEquipment(equipment: Equipment)
    }

    interface Presenter {
        fun getEquipment(equipmentName: String?)
    }

    interface Callback {
        fun onSuccess(equipment: Equipment)
        fun onError()
        fun onFailure()
    }

    interface Api {
        fun getEquipment(equipmentName: String, callback: Callback)
    }

}