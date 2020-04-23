package com.example.dd5th.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dd5th.R
import kotlinx.android.synthetic.main.list_item.view.textview_item_options

class TypicalSpeakersListAdapter(
    val speakers: ArrayList<String>,
    val context: Context
) : RecyclerView.Adapter<TypicalSpeakersListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(languageSpeaker: String) {
            itemView.textview_item_options.text = languageSpeaker
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.list_item, parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return speakers.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(speakers[position])
    }
}