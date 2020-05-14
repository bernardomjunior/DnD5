package com.example.dd5th.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dd5th.R
import com.example.dd5th.data.domain.ApiListItemResponse
import kotlinx.android.synthetic.main.list_item.view.textview_item_options

class AbilityScoreSkillListAdapter(
    private val resources: List<ApiListItemResponse>,
    private val context: Context,
    private val listener: (ApiListItemResponse) -> Unit
) : RecyclerView.Adapter<AbilityScoreSkillListAdapter.ViewHolder>() {

    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind(listItem: ApiListItemResponse, listener: (ApiListItemResponse) -> Unit) {
            itemView.textview_item_options.text = listItem.name
            itemView.setOnClickListener { listener(listItem) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.list_item, parent, false
            )
        )
    }

    override fun getItemCount() = resources.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(resources[position], listener)
    }
}