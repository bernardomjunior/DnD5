package com.example.dd5th.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dd5th.R
import com.example.dd5th.data.external.ApiRepository
import com.example.dd5th.ui.adapter.HomeListAdapter
import kotlinx.android.synthetic.main.generic_listing.list_app_options

class HomeActivity : AppCompatActivity() {

    private val options = HashMap<String, String>()
    private val repository = ApiRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.generic_listing)
        setList()
        repository.listApiOptions(this)
    }

    private fun setList() {
        list_app_options.layoutManager = LinearLayoutManager(this)
        list_app_options.adapter =
            HomeListAdapter(options, this) { option: String, optionValue: String ->
                val intent = Intent(applicationContext, ResourceListActivity::class.java)
                intent.putExtra("option", option)
                intent.putExtra("optionValue", optionValue)
                startActivity(intent)
            }
    }

    fun upDateOptionList(dictionary: HashMap<String, String>) {
        options.clear()
        options.putAll(updateOptionsKeys(dictionary))
        list_app_options.adapter?.notifyDataSetChanged()
    }


    fun updateOptionsKeys(dictionary: HashMap<String, String>): HashMap<String, String> {

        val newDictionary = HashMap<String, String>()
        val dictionaryKeys = dictionary.keys
        dictionaryKeys.forEach { key ->
            println(key)
            dictionary[key]?.let {
                newDictionary[capitalizeOption(key)] = dictionary[key]!!
            }
        }
        return newDictionary
    }

    fun capitalizeOption(option: String): String {
        var newStr = ""
        option.split("-").forEach {
            newStr += it[0].toUpperCase() + it.slice(1 until it.length) + " "
        }
        return newStr
    }


}