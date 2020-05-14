package com.example.dd5th.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dd5th.R
import com.example.dd5th.contract.GenericResourceListingContract
import com.example.dd5th.presenter.GenericResourceListingPresenter
import com.example.dd5th.ui.adapter.GenericResourceListAdapter
import kotlinx.android.synthetic.main.generic_listing.list_app_options


class GenericResourceListActivity : AppCompatActivity(), GenericResourceListingContract.View {

    private val presenter = GenericResourceListingPresenter(this)
    private val options = HashMap<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.generic_listing)
        setList()
        presenter.listOptions()
    }

    private fun setList() {
        list_app_options.layoutManager = LinearLayoutManager(this)
        list_app_options.adapter =
            GenericResourceListAdapter(options, this) { option: String, optionValue: String ->
                val intent = presenter.addExtras(
                    Intent(applicationContext, SpecificResourceListActivity::class.java),
                    option,
                    optionValue)
                startActivity(intent)
            }
    }



    override fun listOptions(dictionary: HashMap<String, String>) {
        options.clear()
        options.putAll(dictionary)
        list_app_options.adapter?.notifyDataSetChanged()
    }

    override fun showErrorMessage(message: String) {
        TODO("Not yet implemented")
    }
}