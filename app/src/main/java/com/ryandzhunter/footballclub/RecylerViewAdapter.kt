package com.ryandzhunter.footballclub

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.ryandzhunter.footballclub.R.layout.item_list
import kotlinx.android.synthetic.main.item_list.view.*

/**
 * Created by ryandzhunter on 4/16/18.
 */
class RecyclerViewAdapter(private val context: Context, private val items: List<Item>,
                          val listener: (Int) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], position, listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        fun bindItem(item: Item, position: Int, listener: (Int) -> Unit) {
            itemView.name.text = item.name
            Glide.with(itemView.context).load(item.image).into(itemView.image)
            itemView.setOnClickListener{
                listener(position)
            }
        }
    }
}