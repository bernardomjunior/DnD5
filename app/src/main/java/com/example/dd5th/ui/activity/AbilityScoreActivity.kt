package com.example.dd5th.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dd5th.R
import com.example.dd5th.contract.AbilityScoreContract
import com.example.dd5th.data.domain.AbilityScore
import com.example.dd5th.presenter.AbilityScorePresenter

class AbilityScoreActivity: AppCompatActivity(), AbilityScoreContract.View {

    private val presenter: AbilityScoreContract.Presenter = AbilityScorePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ability_score)
    }

    override fun showAbilityScore(abilityScore: AbilityScore) {
        TODO("Not yet implemented")
    }

}