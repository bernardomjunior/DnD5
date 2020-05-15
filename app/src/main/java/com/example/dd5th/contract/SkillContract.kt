package com.example.dd5th.contract

import com.example.dd5th.data.domain.Skill

interface SkillContract {

    interface View {
        fun onSkillResult(skill: Skill)
    }

    interface Presenter {
        fun getSkill(skillName: String?)
    }

    interface Callback {
        fun onSuccess(skill: Skill)
        fun onFailure()
        fun onError()
    }

    interface Api {
        fun getSkill(skillName: String, callback: Callback)
    }

}