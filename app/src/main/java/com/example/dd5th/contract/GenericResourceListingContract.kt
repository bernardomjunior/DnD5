package com.example.dd5th.contract

import android.content.Intent

interface GenericResourceListingContract {

    interface View{
        fun listOptions(dictionary: HashMap<String, String>)
        fun showErrorMessage(message: String)
    }

    interface Presenter {
        fun listOptions()
        fun addExtras(
            intent: Intent,
            option: String,
            optionValue: String
        ): Intent
    }

    interface Callback {
        fun onSuccess(dict: HashMap<String, String>)
        fun onError()
        fun onFailure()
    }

    interface Api {
        fun listApiOptions(callback: Callback)
    }

}