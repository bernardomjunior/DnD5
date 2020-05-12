package com.example.dd5th.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dd5th.R
import com.example.dd5th.contract.EquipmentContract
import com.example.dd5th.data.domain.Equipment
import com.example.dd5th.presenter.EquipmentPresenter
import kotlinx.android.synthetic.main.activity_equipment.txt_equipment_name
import kotlinx.android.synthetic.main.activity_equipment.txt_equipment_category
import kotlinx.android.synthetic.main.activity_equipment.txt_equipment_gear_category
import kotlinx.android.synthetic.main.activity_equipment.txt_equipment_cost_ammount
import kotlinx.android.synthetic.main.activity_equipment.txt_equipment_cost_unit
import kotlinx.android.synthetic.main.activity_equipment.txt_equipment_weight

class EquipmentActivity: AppCompatActivity(), EquipmentContract.View {

    private lateinit var equipment: Equipment
    private val presenter = EquipmentPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipment)
        presenter.getEquipmentIfExtra(intent.extras)
    }

    private fun fillFields() {
        txt_equipment_name.text = equipment.name
        txt_equipment_category.text = equipment.equipmentCategory
        txt_equipment_gear_category.text = equipment.gearCategory
        txt_equipment_cost_ammount.text = equipment.cost.quantity.toString()
        txt_equipment_cost_unit.text = equipment.cost.unit
        txt_equipment_weight.text = equipment.weight.toString()
    }

    override fun showEquipment(equipment: Equipment) {
        this.equipment = equipment
        fillFields()
    }
}