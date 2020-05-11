package com.example.dd5th.presenter

import com.example.dd5th.contract.LanguageContract
import com.example.dd5th.data.domain.Language
import com.example.dd5th.data.external.ApiRepository

class LanguagePresenter (
    private val view: LanguageContract.View
): LanguageContract.Presenter, LanguageContract.Callback {

    private val api: LanguageContract.Api = ApiRepository()

    override fun getLanguage(languageName: String) {
        api.getLanguage(languageName, this)
    }

    override fun onSuccess(language: Language) {
        view.onLanguageResult(language)
    }

    override fun onFailure() {
        TODO("Not yet implemented")
    }

    override fun onError() {
        TODO("Not yet implemented")
    }
}