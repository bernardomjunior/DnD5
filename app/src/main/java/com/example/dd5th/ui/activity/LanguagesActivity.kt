package com.example.dd5th.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dd5th.R
import com.example.dd5th.contract.LanguageContract
import com.example.dd5th.data.domain.Language
import com.example.dd5th.presenter.LanguagePresenter
import com.example.dd5th.ui.adapter.TypicalSpeakersListAdapter
import com.example.dd5th.util.ActivityExtrasConstants.Companion.LANGUAGES
import kotlinx.android.synthetic.main.activity_languages.txt_language_name
import kotlinx.android.synthetic.main.activity_languages.txt_language_script
import kotlinx.android.synthetic.main.activity_languages.txt_language_type
import kotlinx.android.synthetic.main.activity_languages.listview_language_typical_speakers

class LanguagesActivity : AppCompatActivity(), LanguageContract.View {

    private lateinit var language: Language
    private val presenter: LanguageContract.Presenter = LanguagePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_languages)
        presenter.getLanguage(intent.extras?.getString(LANGUAGES))

    }

    override fun onLanguageResult(language: Language) {
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