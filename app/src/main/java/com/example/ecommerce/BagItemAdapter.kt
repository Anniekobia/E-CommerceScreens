package com.example.ecommerce

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class BagItemAdapter(private val list: List<BagItem>, val ctx: Context)
    : RecyclerView.Adapter<BagItemViewHolder>() {

    var price : Float = 0F

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BagItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return BagItemViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: BagItemViewHolder, position: Int) {
        val bagItem: BagItem = list[position]

        price += bagItem.item_price.toFloat()
        val sharedPref = ctx.getSharedPreferences("Shared Pref",Context.MODE_PRIVATE)
        with (sharedPref.edit()) {
            putFloat("Total Price", price)
            commit()
        }
        bagItem.item_price = "$"+ bagItem.item_price.toFloat()
        holder.bind(bagItem)
    }

    override fun getItemCount(): Int = list.size


}





