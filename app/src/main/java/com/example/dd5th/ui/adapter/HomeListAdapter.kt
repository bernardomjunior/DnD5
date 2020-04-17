package com.example.dd5th.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dd5th.R
import kotlinx.android.synthetic.main.list_item.view.textview_item_options

class HomeListAdapter(
    private val options: HashMap<String, String>,
    private val context: Context,
    private val listener: (String, String) -> Unit
) : RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(option: String, optionValue: String, listener: (String, String) -> Unit) {
            itemView.textview_item_options.text = option
            itemView.setOnClickListener { listener(option, optionValue) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return options.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val key = options.keys.toList().sorted()[position]
        holder.bind(key, options[key]!!, listener)
    }
}