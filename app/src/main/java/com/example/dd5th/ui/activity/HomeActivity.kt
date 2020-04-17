package com.example.dd5th.ui.activity


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dd5th.R
import com.example.dd5th.data.external.ApiOptionsRepository
import com.example.dd5th.ui.adapter.HomeListAdapter
import kotlinx.android.synthetic.main.generic_listing.*
class HomeActivity : AppCompatActivity() {

    private val options = HashMap<String, String>()
    private val repository = ApiOptionsRepository(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.generic_listing)
        setList()
        repository.listApiOptions()
    }

    private fun setList() {
        list_app_options.layoutManager = LinearLayoutManager(this)
        list_app_options.adapter = HomeListAdapter(options, this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    fun upDateOptionList(dictionary: HashMap<String, String>){
        options.clear()
        options.putAll(updateOptionsKeys(dictionary))
        list_app_options.adapter?.notifyDataSetChanged()
    }


    fun updateOptionsKeys(dictionary: HashMap<String, String>): HashMap<String, String>{

        val newDictionary = HashMap<String, String>()
        val dictionaryKeys = dictionary.keys
        dictionaryKeys.forEach{ key ->
            println(key)
            dictionary[key]?.let {
                newDictionary[capitalizeOption(key)] =  dictionary[key]!!
            }
        }
        return newDictionary
    }

    fun capitalizeOption(option: String): String{
        var newStr = ""
        option.split("-").forEach {
            newStr+= it[0].toUpperCase() + it.slice(1 until it.length) + " "
        }
        return newStr
    }


}