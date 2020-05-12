package com.example.dd5th.presenter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.dd5th.contract.SpecificResourceListingContract
import com.example.dd5th.data.domain.ApiListItemResponse
import com.example.dd5th.data.external.ApiRepository
import com.example.dd5th.ui.activity.AbilityScoreActivity
import com.example.dd5th.ui.activity.EquipmentActivity
import com.example.dd5th.ui.activity.LanguagesActivity
import com.example.dd5th.util.OPTION
import com.example.dd5th.util.OPTION_VALUE
import com.example.dd5th.util.EQUIPMENT
import com.example.dd5th.util.LANGUAGES
import com.example.dd5th.util.ABILITY_SCORES



class SpecificResourceListingPresenter(
    private val view: SpecificResourceListingContract.View
): SpecificResourceListingContract.Presenter, SpecificResourceListingContract.Callback {

    private val api: SpecificResourceListingContract.Api = ApiRepository()

    override fun getList(resourceName: String) {
        api.listResourceItems(resourceName, this)
    }

    override fun onSuccess(list: ArrayList<ApiListItemResponse>) {
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
            it.getString(OPTION)?.let { option ->
                view.setActionBarTitle(option)
            }
            it.getString(OPTION_VALUE)?.let { value ->
                return value
            }
        }
        return null
    }

    override fun getItemActivity(context: Context, resourceItem: String, itemResponse: String): Intent? {
        val intent =  when(resourceItem){
            EQUIPMENT -> Intent(context, EquipmentActivity::class.java)
            LANGUAGES -> Intent(context, LanguagesActivity::class.java)
            ABILITY_SCORES-> Intent(context, AbilityScoreActivity::class.java)
//            CLASSES -> Intent(context, EquipmentActivity::class.java)
//            CONDITIONS -> Intent(context, EquipmentActivity::class.java)
//            DAMAGE_TYPES -> Intent(context, EquipmentActivity::class.java)
//            EQUIPMENT_CATEGORIES -> Intent(context, EquipmentActivity::class.java)
//            FEATURES -> Intent(context, EquipmentActivity::class.java)
//            MAGIC_SCHOOLS -> Intent(context, EquipmentActivity::class.java)
//            MONSTERS -> Intent(context, EquipmentActivity::class.java)
//            PROFICIENCIES -> Intent(context, EquipmentActivity::class.java)
//            RACES -> Intent(context, EquipmentActivity::class.java)
//            SKILLS -> Intent(context, EquipmentActivity::class.java)
//            SPELLCASTING -> Intent(context, EquipmentActivity::class.java)
//            SPELLS -> Intent(context, EquipmentActivity::class.java)
//            STARTING_EQUIPMENT -> Intent(context, EquipmentActivity::class.java)
//            SUBCLASSES -> Intent(context, EquipmentActivity::class.java)
//            SUBRACES -> Intent(context, EquipmentActivity::class.java)
//            TRAITS -> Intent(context, EquipmentActivity::class.java)
//            WEAPON_PROPERTIES -> Intent(context, EquipmentActivity::class.java)
            else -> null
        }
        return intent?.putExtra(resourceItem, itemResponse)
    }

}