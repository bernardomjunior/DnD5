package com.example.dd5th.contract

interface GenericResourceListingContract {

    interface View{
        fun listOptions(dictionary: HashMap<String, String>)
        fun showErrorMessage(message: String)
    }

    interface Presenter {
        fun listOptions()
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