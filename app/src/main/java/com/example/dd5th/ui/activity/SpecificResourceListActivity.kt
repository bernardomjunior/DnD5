package com.example.dd5th.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dd5th.R
import com.example.dd5th.contract.SpecificResourceListingContract
import com.example.dd5th.data.domain.ApiListItemResponse
import com.example.dd5th.presenter.SpecificResourceListingPresenter
import com.example.dd5th.ui.adapter.SpecificResourceListAdapter
import kotlinx.android.synthetic.main.generic_listing.list_app_options

class SpecificResourceListActivity: AppCompatActivity(), SpecificResourceListingContract.View {

    private val presenter = SpecificResourceListingPresenter(this)
    private val resourceList = ArrayList<ApiListItemResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.generic_listing)
        setUpFields()
    }

    override fun showList(list: ArrayList<ApiListItemResponse>) {
        resourceList.clear()
        resourceList.addAll(list)
        list_app_options.adapter?.notifyDataSetChanged()
    }

    override fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun setUpFields() {
        val endPoint = presenter.getExtras(intent.extras)
        endPoint?.let {
            setUpList(it)
            presenter.getList(it)
        }
    }

    private fun setUpList(endPoint: String) {
        list_app_options.layoutManager = LinearLayoutManager(this)
        list_app_options.adapter = SpecificResourceListAdapter( resourceList, this){
            startItemActivity(endPoint, it.index)
        }
    }

    private fun startItemActivity(resourceString: String, itemResponse: String){
        val newIntent = presenter.getItemActivity(this, resourceString)
        newIntent?.let {
            it.putExtra(resourceString, itemResponse)
            startActivity(it)
        }
    }

}