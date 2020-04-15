package com.example.dd5th.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dd5th.R
import com.example.dd5th.ui.adapter.HomeListAdapter
import kotlinx.android.synthetic.main.generic_listing.*

class HomeActivity : AppCompatActivity() {

    private val options = ArrayList(listOf("Monsters", "Classes", "Spells"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.generic_listing)
        setList()
    }

    private fun setList() {
        list_app_options.layoutManager = LinearLayoutManager(this)
        list_app_options.adapter = HomeListAdapter(options, this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

}