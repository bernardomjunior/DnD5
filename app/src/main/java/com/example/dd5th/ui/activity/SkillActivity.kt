package com.example.dd5th.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dd5th.R
import com.example.dd5th.contract.SkillContract
import com.example.dd5th.data.domain.Skill
import com.example.dd5th.presenter.SkillPresenter
import com.example.dd5th.util.ActivityExtrasConstants.Companion.SKILLS
import kotlinx.android.synthetic.main.activity_skill.txt_skill_description
import kotlinx.android.synthetic.main.activity_skill.txt_skill_name
import kotlinx.android.synthetic.main.activity_skill.txt_skill_related_abilitiy

class SkillActivity : AppCompatActivity(), SkillContract.View {

    private val presenter: SkillContract.Presenter = SkillPresenter(this)
    private lateinit var skill: Skill

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        presenter.getSkill(intent.extras?.getString(SKILLS))
    }

    override fun onSkillResult(skill: Skill) {
        this.skill = skill
        fillFields()
    }

    private fun fillFields() {
        txt_skill_name.text = skill.name
        txt_skill_description.text = presenter.listToText(skill.description)
        txt_skill_related_abilitiy.text = skill.abilityScoreApiItem.name
    }

}