package com.example.dd5th.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dd5th.R
import com.example.dd5th.data.domain.Language

class LanguagesActivity : AppCompatActivity() {

    private lateinit var language: Language

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_languages)
        val languageIndex = intent.extras?.getString("languages")
        languageIndex?.let {

        }
    }

}