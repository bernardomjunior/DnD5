package com.example.dd5th.presenter

import com.example.dd5th.contract.SkillContract
import com.example.dd5th.data.domain.ApiListItemResponse
import com.example.dd5th.data.domain.Skill
import com.example.dd5th.data.external.ApiRepository

class SkillPresenter(
    private val view: SkillContract.View
) : SkillContract.Presenter, SkillContract.Callback {

    private val api: SkillContract.Api = ApiRepository

    override fun getSkill(skillName: String?) {
        skillName?.let {
            api.getSkill(it, this)
        }
    }

    override fun onSuccess(skill: Skill) {
        view.onSkillResult(
            Skill(
                index = skill.index,
                name = skill.name,
                description = skill.description,
                abilityScoreApiItem = ApiListItemResponse(
                    index = getIndexFromUrl(skill.abilityScoreApiItem.url),
                    name = skill.abilityScoreApiItem.name,
                    url = skill.abilityScoreApiItem.url
                )
            )
        )
    }

    override fun onFailure() {
        TODO("Not yet implemented")
    }

    override fun onError() {
        TODO("Not yet implemented")
    }

    private fun getIndexFromUrl(url: String): String {
        return url.split("/").last()
    }

    override fun listToText(description: List<String>) = description.joinToString("\n\n")

}