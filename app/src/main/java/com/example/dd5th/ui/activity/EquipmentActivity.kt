package com.example.dd5th.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dd5th.R
import com.example.dd5th.data.domain.Equipment
import com.example.dd5th.data.external.ApiRepository
import kotlinx.android.synthetic.main.activity_equipment.*

class EquipmentActivity: AppCompatActivity() {

    private lateinit var equipment: Equipment
    private val api = ApiRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipment)
        val equipmentIndex = getEquipmentIndexExtra()
        equipmentIndex?.let {
            api.getEquipment(it, this)
        }
    }

    private fun fillFields() {
        txt_equipment_name.text = equipment.name
        txt_equipment_category.text = equipment.equipmentCategory
        txt_equipment_gear_category.text = equipment.gearCategory
    }

    private fun getEquipmentIndexExtra() : String?{
        intent.extras?.let {
            if (it.containsKey("equipment")) {
                return it.getString("equipment")
            }
        }
        return null
    }

    fun onEquipmentResult(equipment: Equipment){
        this.equipment = equipment
        fillFields()
    }

}