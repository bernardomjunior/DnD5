package com.example.dd5th.presenter

import android.os.Bundle
import com.example.dd5th.contract.SkillContract
import com.example.dd5th.data.domain.Skill
import com.example.dd5th.data.external.ApiRepository
import com.example.dd5th.util.ActivityExtrasConstants.Companion.SKILLS

class SkillPresenter(
    private val view: SkillContract.View
): SkillContract.Presenter, SkillContract.Callback {

    private val api: SkillContract.Api = ApiRepository

    override fun getSkill(skillName: String?) {
        skillName?.let {
            api.getSkill(it, this)
        }
    }

    override fun onSuccess(skill: Skill) {
        view.onSkillResult(skill)
    }

    override fun onFailure() {
        TODO("Not yet implemented")
    }

    override fun onError() {
        TODO("Not yet implemented")
    }
}