package com.example.for_remember

import android.annotation.SuppressLint
import android.util.Log
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: List<ItemsViewModel>,private val itemClickListener: ItemClickListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(mList[position])
        holder.btn_add.setOnClickListener {
            itemClickListener.add(mList[position],position)
        }
        holder.btn_minus.setOnClickListener {
            itemClickListener.minus(mList[position],position)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val btn_add: Button = view.findViewById(R.id.btn_add)
        val btn_minus: Button = view.findViewById(R.id.btn_minus)
        val tv_count: TextView = view.findViewById(R.id.tv_count)
        fun bindData(itemsViewModel: ItemsViewModel) {
            tv_count.text = "${itemsViewModel.itemCount}"
        }
    }
}