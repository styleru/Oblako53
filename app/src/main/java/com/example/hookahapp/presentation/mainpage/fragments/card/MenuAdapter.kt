package com.example.hookahapp.presentation.mainpage.fragments.card

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.hookahapp.R
import com.example.hookahapp.presentation.mainpage.SingleMenuItemFragment.Companion.BAR
import com.example.hookahapp.presentation.mainpage.SingleMenuItemFragment.Companion.BEVERAGE
import com.example.hookahapp.presentation.mainpage.SingleMenuItemFragment.Companion.COCKTAILS
import com.example.hookahapp.presentation.mainpage.SingleMenuItemFragment.Companion.DESSERTS
import com.example.hookahapp.presentation.mainpage.SingleMenuItemFragment.Companion.EXIT
import com.example.hookahapp.presentation.mainpage.SingleMenuItemFragment.Companion.HOOKAH
import com.example.hookahapp.presentation.mainpage.SingleMenuItemFragment.Companion.JAPANESE_KITCHEN
import com.example.hookahapp.presentation.mainpage.SingleMenuItemFragment.Companion.PIZZA
import com.example.hookahapp.presentation.mainpage.SingleMenuItemFragment.Companion.SNACKS
import com.example.hookahapp.presentation.mainpage.fragments.MenuCallback

class MenuAdapter(val callback: MenuCallback) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    val items = arrayListOf(R.string.contacts, R.string.hookah, R.string.pizza, R.string.desserts,
            R.string.japanese_kitchen, R.string.beverages, R.string.snacks, R.string.bar, R.string.coctails, R.string.exit)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holder = if (viewType == 1)
            MenuViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false))
        else
            MenuImageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.menu_image_item, parent, false))
        holder.itemView.setOnClickListener {
            when(holder.adapterPosition){
                0 -> {holder as MenuImageViewHolder
                    if (holder.contactsTextView.visibility == View.GONE) {
                        holder.contactsTextView.visibility = View.VISIBLE
                        holder.background.visibility = View.VISIBLE
                        //holder.background.setBackgroundColor(ContextCompat.getColor(holder.background.context, R.color.menu_item))
                    }
                    else{
                        holder.contactsTextView.visibility = View.GONE
                        holder.background.visibility = View.GONE
                        //holder.background.setBackgroundColor(ContextCompat.getColor(holder.background.context, android.R.color.transparent))
                    }
                }
                1 -> callback.onMenuItemClicked(HOOKAH)
                2 -> callback.onMenuItemClicked(PIZZA)
                3 -> callback.onMenuItemClicked(DESSERTS)
                4 -> callback.onMenuItemClicked(JAPANESE_KITCHEN)
                5 -> callback.onMenuItemClicked(BEVERAGE)
                6 -> callback.onMenuItemClicked(SNACKS)
                7 -> callback.onMenuItemClicked(BAR)
                8 -> callback.onMenuItemClicked(COCKTAILS)
                9 -> callback.onMenuItemClicked(EXIT)
                else -> throw Exception("индекс аут оф баундc эксепшн епта")
            }
        }
        return holder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) 0 else 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MenuImageViewHolder) {
            holder.menuImageView.setImageResource(R.drawable.cloud)
            holder.menuTextView.text = holder.menuTextView.context.getText(items[position]) // вытаскиваем контекст через жопу
            holder.contactsTextView.visibility = View.GONE
            holder.background.visibility = View.GONE
        }
        else {
            holder as MenuViewHolder
            if (items[position] == R.string.exit) {
                holder.menuCardView.setBackgroundColor(Color.TRANSPARENT)
                holder.menuTextView.visibility = View.INVISIBLE
                holder.menuExitRextView.visibility = View.VISIBLE
                holder.menuExitRextView.setText(items[position])
            }
            holder.menuTextView.text = holder.menuTextView.context.getText(items[position]) // вытаскиваем контекст через жопу
        }
    }

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val menuCardView: CardView = itemView.findViewById(R.id.menuCardView)
        val menuTextView : TextView = itemView.findViewById(R.id.menuSingleTextView)
        val menuExitRextView: TextView = itemView.findViewById(R.id.menuSingleExitTextView)
    }

    class MenuImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val menuTextView : TextView = itemView.findViewById(R.id.menuTextView)
        val menuImageView : ImageView = itemView.findViewById(R.id.menuImageView)
        val contactsTextView : TextView = itemView.findViewById(R.id.contactsTextView)
        val background : LinearLayout = itemView.findViewById(R.id.itemBackground)
    }
}