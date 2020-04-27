package com.example.dd5th.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dd5th.R
import com.example.dd5th.data.domain.Language
import com.example.dd5th.data.external.ApiRepository
import com.example.dd5th.ui.adapter.TypicalSpeakersListAdapter
import kotlinx.android.synthetic.main.activity_languages.*

class LanguagesActivity : AppCompatActivity() {

    private lateinit var language: Language
//    private val api = ApiRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_languages)
        val languageIndex = intent.extras?.getString("languages")
        languageIndex?.let {
//            api.getLanguage(it, this)
        }
    }

    fun onLanguageResult(language: Language) {
        this.language = language
        fillFields()
    }

    private fun fillFields() {
        txt_language_name.text = language.name
        txt_language_script.text = language.script
        txt_language_type.text = language.type
        listview_language_typical_speakers.adapter = TypicalSpeakersListAdapter(language.typicalSpeakers, baseContext)
    }

}