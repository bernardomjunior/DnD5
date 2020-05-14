package com.example.dd5th.presenter

import android.content.Intent
import com.example.dd5th.contract.GenericResourceListingContract
import com.example.dd5th.data.external.ApiRepository

class GenericResourceListingPresenter(
    private val view: GenericResourceListingContract.View
): GenericResourceListingContract.Presenter, GenericResourceListingContract.Callback {

    private val api: GenericResourceListingContract.Api = ApiRepository()

    override fun listOptions() {
        api.listApiOptions(this)
    }

    override fun onSuccess(dict: HashMap<String, String>) {
        view.listOptions(updateOptionsKeys(dict))
    }

    override fun onError() {
        TODO("Not yet implemented")
    }

    override fun onFailure() {
        TODO("Not yet implemented")
    }

    private fun updateOptionsKeys(dictionary: HashMap<String, String>): HashMap<String, String> {
        val newDictionary = HashMap<String, String>()
        val dictionaryKeys = dictionary.keys
        dictionaryKeys.forEach { key ->
            dictionary[key]?.let {
                newDictionary[capitalizeOption(key)] = key
            }
        }
        return newDictionary
    }

    private fun capitalizeOption(option: String): String {
        var newStr = ""
        option.split("-").forEach {
            newStr += it[0].toUpperCase() + it.slice(1 until it.length) + " "
        }
        return newStr
    }

    override fun addExtras(intent: Intent, option: String, optionValue: String): Intent {
        intent.putExtra(OPTION, option)
        intent.putExtra(OPTION_VALUE, optionValue)
        return intent
    }

}