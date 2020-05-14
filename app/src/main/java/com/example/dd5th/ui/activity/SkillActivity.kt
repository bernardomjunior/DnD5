package com.example.dd5th.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dd5th.R
import com.example.dd5th.contract.SkillContract
import com.example.dd5th.data.domain.Skill
import com.example.dd5th.presenter.SkillPresenter

class SkillActivity: AppCompatActivity(), SkillContract.View{

    private val presenter: SkillContract.Presenter = SkillPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
    }

    override fun onSkillResult(skill: Skill) {
        TODO("Not yet implemented")
    }
}