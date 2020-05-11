package com.example.dd5th.contract

import com.example.dd5th.data.domain.Language

interface LanguageContract {
    interface View
    interface Presenter
    interface Callback {
        fun onSuccess(language: Language)
        fun onFailure()
        fun onError()
    }
    interface Api {
        fun getLanguage(languageName: String, callback: Callback)
    }
}