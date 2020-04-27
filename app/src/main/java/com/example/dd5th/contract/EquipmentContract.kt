package com.example.dd5th.contract

import android.os.Bundle
import com.example.dd5th.data.domain.Equipment

interface EquipmentContract {

    interface View {
        fun showEquipment(equipment: Equipment)
    }

    interface Presenter {
        fun getEquipmentIfExtra(extras: Bundle?)
    }

    interface Callback {
        fun onSucess(equipment: Equipment)
        fun onError()
        fun onFailure()
    }

    interface Api {
        fun getEquipment(equipmentName: String, callback: Callback)
    }

}