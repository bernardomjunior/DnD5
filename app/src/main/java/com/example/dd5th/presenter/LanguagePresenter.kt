package com.example.dd5th.presenter

import android.os.Bundle
import com.example.dd5th.contract.LanguageContract
import com.example.dd5th.data.domain.Language
import com.example.dd5th.data.external.ApiRepository
import com.example.dd5th.util.ActivityExtrasConstants.Companion.LANGUAGES

class LanguagePresenter (
    private val view: LanguageContract.View
): LanguageContract.Presenter, LanguageContract.Callback {

    private val api: LanguageContract.Api = ApiRepository

    override fun getLanguage(languageName: String?) {
        languageName?.let {
            api.getLanguage(it, this)
        }
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