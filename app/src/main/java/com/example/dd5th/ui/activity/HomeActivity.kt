package com.example.dd5th.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dd5th.R
import com.example.dd5th.ui.adapter.HomeListAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val options = ArrayList(listOf("Monsters", "Classes", "Spells"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setList()
    }

    private fun setList() {
        list_app_options.adapter = HomeListAdapter(options, this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }

}