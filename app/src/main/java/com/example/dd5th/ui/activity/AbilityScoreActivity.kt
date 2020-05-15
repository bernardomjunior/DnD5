package com.example.dd5th.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dd5th.R
import com.example.dd5th.contract.AbilityScoreContract
import com.example.dd5th.data.domain.AbilityScore
import com.example.dd5th.presenter.AbilityScorePresenter
import com.example.dd5th.ui.adapter.AbilityScoreSkillListAdapter
import com.example.dd5th.util.ActivityExtrasConstants.Companion.ABILITY_SCORES
import kotlinx.android.synthetic.main.activity_ability_score.txt_ability_score_full_name
import kotlinx.android.synthetic.main.activity_ability_score.txt_ability_score_description
import kotlinx.android.synthetic.main.activity_ability_score.listview_ability_score_skills

class AbilityScoreActivity: AppCompatActivity(), AbilityScoreContract.View {

    private lateinit var abilityScore: AbilityScore
    private val presenter: AbilityScoreContract.Presenter = AbilityScorePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ability_score)
        presenter.getAbilityScore(intent.extras?.getString(ABILITY_SCORES))
    }

    override fun showAbilityScore(abilityScore: AbilityScore) {
        this.abilityScore = abilityScore
        fillFields()
    }

    private fun fillFields(){
        txt_ability_score_full_name.text = abilityScore.fullName
        txt_ability_score_description.text = listToText(abilityScore.description)
        setUpSkills()
    }

    private fun setUpSkills() {
        listview_ability_score_skills.layoutManager = LinearLayoutManager(this@AbilityScoreActivity)
        listview_ability_score_skills.adapter = AbilityScoreSkillListAdapter(
            abilityScore.skills, this@AbilityScoreActivity
        ) {
            TODO("OPEN INTENT TO CREATE SKILL ACTIVITY")
        }
    }

    private fun listToText(description: List<String>) = description.joinToString("\n\n")

}