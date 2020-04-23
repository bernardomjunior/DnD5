package com.example.dd5th.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dd5th.R
import com.example.dd5th.data.domain.ApiListItemResponse
import com.example.dd5th.data.external.ApiRepository
import com.example.dd5th.ui.adapter.GenericResourceListAdapter
import kotlinx.android.synthetic.main.generic_listing.list_app_options

class ResourceListActivity: AppCompatActivity() {

    private val repository = ApiRepository()
    private val resourceList = ArrayList<ApiListItemResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.generic_listing)
        setUpFields()
    }

    private fun setUpFields() {
        val endPoint = getExtras()
        endPoint?.let {
            setUpList(it)
            getResourceList(it)
        }
    }

    private fun setUpList(endPoint: String) {
        list_app_options.layoutManager = LinearLayoutManager(this)
        list_app_options.adapter = GenericResourceListAdapter( resourceList, this){
            startItemActivity(endPoint, it.index)
        }
    }

    private fun getExtras() : String?{
        intent.extras?.let {
            if (it.containsKey("option")) {
                supportActionBar?.title = it.getString("option")
            }
            if (it.containsKey("optionValue")) {
                return it.getString("optionValue")!!
            }
        }
        return null
    }

    private fun getResourceList(resourceUrl: String) {
        repository.listResourceItems(resourceUrl, this)
    }

    fun updateList(resourceList: ArrayList<ApiListItemResponse>) {
        this.resourceList.clear()
        this.resourceList.addAll(resourceList)
        list_app_options.adapter?.notifyDataSetChanged()
    }

    private fun startItemActivity(resourceString: String, itemResponse: String){
        val intent = when(resourceString){
            "equipment" -> Intent(this, EquipmentActivity::class.java)
            "languages" -> Intent(this, LanguagesActivity::class.java)
//            "ability-scores" -> Intent(this, EquipmentActivity::class.java)
//            "classes" -> Intent(this, EquipmentActivity::class.java)
//            "conditions" -> Intent(this, EquipmentActivity::class.java)
//            "damage-types" -> Intent(this, EquipmentActivity::class.java)
//            "equipment-categories" -> Intent(this, EquipmentActivity::class.java)
//            "features" -> Intent(this, EquipmentActivity::class.java)
//            "magic-schools" -> Intent(this, EquipmentActivity::class.java)
//            "monsters" -> Intent(this, EquipmentActivity::class.java)
//            "proficiencies" -> Intent(this, EquipmentActivity::class.java)
//            "races" -> Intent(this, EquipmentActivity::class.java)
//            "skills" -> Intent(this, EquipmentActivity::class.java)
//            "spellcasting" -> Intent(this, EquipmentActivity::class.java)
//            "spells" -> Intent(this, EquipmentActivity::class.java)
//            "starting-equipment" -> Intent(this, EquipmentActivity::class.java)
//            "subclasses" -> Intent(this, EquipmentActivity::class.java)
//            "subraces" -> Intent(this, EquipmentActivity::class.java)
//            "traits" -> Intent(this, EquipmentActivity::class.java)
//            "weapon-properties" -> Intent(this, EquipmentActivity::class.java)
            else -> null
        }
        intent?.let {
            it.putExtra(resourceString, itemResponse)
            startActivity(it)
        }
    }

}