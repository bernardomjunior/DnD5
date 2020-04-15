package com.example.dd5th.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dd5th.R
import kotlinx.android.synthetic.main.home_options_list_item.view.*

class HomeListAdapter(
    private val options: ArrayList<String>,
    private val context: Context,
    private val listener: (String) -> Unit
) : RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(option: String, listener: (String) -> Unit) {
            itemView.textview_item_options.text = option
            itemView.setOnClickListener { listener(option) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.home_options_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return options.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(options[position], listener)
    }
}