package com.example.dd5th.presenter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.dd5th.contract.SpecificResourceListingContract
import com.example.dd5th.data.domain.ApiListItemResponse
import com.example.dd5th.data.external.ApiRepository
import com.example.dd5th.ui.activity.EquipmentActivity
import com.example.dd5th.ui.activity.LanguagesActivity

class SpecificResourceListingPresenter(
    private val view: SpecificResourceListingContract.View
): SpecificResourceListingContract.Presenter, SpecificResourceListingContract.Callback {

    private val api: SpecificResourceListingContract.Api = ApiRepository()

    override fun getList(resourceName: String) {
        Log.w("Specific listing", resourceName)
        api.listResourceItems(resourceName, this)
    }

    override fun onSuccess(list: ArrayList<ApiListItemResponse>) {
        Log.w("Specific listing", "onSuccess")
        view.showList(list)
    }

    override fun onError() {
        TODO("Not yet implemented")
    }

    override fun onFailure() {
        TODO("Not yet implemented")
    }

    override fun getExtras(extras: Bundle?): String?{
        extras?.let {
            if (it.containsKey("option")) {
                view.setActionBarTitle(it.getString("option")!!)
            }
            if (it.containsKey("optionValue")) {
                return it.getString("optionValue")!!
            }
        }
        return null
    }

    override fun getItemActivity(context: Context, resourceItem: String): Intent? {
        return when(resourceItem){
            "equipment" -> Intent(context, EquipmentActivity::class.java)
            "languages" -> Intent(context, LanguagesActivity::class.java)
//            "ability-scores" -> Intent(context, EquipmentActivity::class.java)
//            "classes" -> Intent(context, EquipmentActivity::class.java)
//            "conditions" -> Intent(context, EquipmentActivity::class.java)
//            "damage-types" -> Intent(context, EquipmentActivity::class.java)
//            "equipment-categories" -> Intent(context, EquipmentActivity::class.java)
//            "features" -> Intent(context, EquipmentActivity::class.java)
//            "magic-schools" -> Intent(context, EquipmentActivity::class.java)
//            "monsters" -> Intent(context, EquipmentActivity::class.java)
//            "proficiencies" -> Intent(context, EquipmentActivity::class.java)
//            "races" -> Intent(context, EquipmentActivity::class.java)
//            "skills" -> Intent(context, EquipmentActivity::class.java)
//            "spellcasting" -> Intent(context, EquipmentActivity::class.java)
//            "spells" -> Intent(context, EquipmentActivity::class.java)
//            "starting-equipment" -> Intent(context, EquipmentActivity::class.java)
//            "subclasses" -> Intent(context, EquipmentActivity::class.java)
//            "subraces" -> Intent(context, EquipmentActivity::class.java)
//            "traits" -> Intent(context, EquipmentActivity::class.java)
//            "weapon-properties" -> Intent(context, EquipmentActivity::class.java)
            else -> null
        }
    }

}