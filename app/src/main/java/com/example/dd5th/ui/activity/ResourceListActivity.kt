package com.example.dd5th.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dd5th.R
import com.example.dd5th.data.domain.ApiListItemResponse
import com.example.dd5th.data.external.ApiRepository
import com.example.dd5th.ui.adapter.GenericResourceListAdapter
import kotlinx.android.synthetic.main.generic_listing.list_app_options

class ResourceListActivity : AppCompatActivity() {

    private val repository = ApiRepository()
    private val resourceList = ArrayList<ApiListItemResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.generic_listing)
        setUpFields()
    }

    private fun setUpFields() {
        setUpList()
        val url = getUrlExtra()
        url?.let {
            getResourceList(it)
        }
    }

    private fun setUpList() {
        list_app_options.layoutManager = LinearLayoutManager(this)
        list_app_options.adapter = GenericResourceListAdapter(resourceList, this){
            Toast.makeText(this,it.url, Toast.LENGTH_SHORT).show()
        }
    }

    private fun getUrlExtra() : String?{
        intent.extras?.let {
            if (it.containsKey("option")) {
                supportActionBar?.title = it.getString("option")
            }
            if (it.containsKey("optionValue")) {
                return it.getString("optionValue")!!
            }
        }
        return null
    }

    private fun getResourceList(resourceUrl: String) {
        repository.listResourceItems(resourceUrl, this)
    }

    fun updateList(resourceList: ArrayList<ApiListItemResponse>) {
        this.resourceList.clear()
        this.resourceList.addAll(resourceList)
        list_app_options.adapter?.notifyDataSetChanged()
    }

}