package com.example.hookahapp.presentation.mainpage.fragments.card

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hookahapp.R

class MenuAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    val items = arrayListOf(R.string.contacts, R.string.hookah, R.string.pizza, R.string.desserts,
            R.string.japanese_kitchen, R.string.beverages, R.string.snacks, R.string.bar, R.string.coctails)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 1)
            MenuViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false))
        else
            MenuImageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.menu_image_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) 0 else 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MenuImageViewHolder) {
            holder.menuImageView.setImageResource(R.drawable.cloud_epic)
            holder.menuTextView.text = holder.menuTextView.context.getText(items[position]) // вытаскиваем контекст через жопу
        }
        else {
            holder as MenuViewHolder
            holder.menuTextView.text = holder.menuTextView.context.getText(items[position]) // вытаскиваем контекст через жопу
        }
    }

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val menuTextView : TextView = itemView.findViewById(R.id.menuSingleTextView)
    }

    class MenuImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val menuTextView : TextView = itemView.findViewById(R.id.menuTextView)
        val menuImageView : ImageView = itemView.findViewById(R.id.menuImageView)
    }
}