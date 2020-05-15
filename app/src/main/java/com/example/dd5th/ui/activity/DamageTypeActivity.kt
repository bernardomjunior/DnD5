package com.example.dd5th.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dd5th.R
import com.example.dd5th.contract.DamageTypeContract
import com.example.dd5th.data.domain.DamageType
import com.example.dd5th.presenter.DamageTypePresenter
import com.example.dd5th.util.ActivityExtrasConstants.Companion.DAMAGE_TYPES
import kotlinx.android.synthetic.main.activity_damage_type.txt_damage_type_description
import kotlinx.android.synthetic.main.activity_damage_type.txt_damage_type_name

class DamageTypeActivity : AppCompatActivity(), DamageTypeContract.View {

    private val presenter: DamageTypeContract.Presenter = DamageTypePresenter(this)
    private lateinit var damageType: DamageType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_damage_type)
        presenter.getDamageType(intent.extras?.getString(DAMAGE_TYPES))
    }

    override fun onDamageTypeResult(damageType: DamageType) {
        this.damageType = damageType
        fillFields(damageType)

    }

    private fun fillFields(damageType: DamageType) {
        txt_damage_type_name.text = damageType.name
        txt_damage_type_description.text = presenter.listToText(damageType.description)
    }
}