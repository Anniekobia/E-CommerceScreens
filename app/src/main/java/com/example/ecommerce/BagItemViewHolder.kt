package com.example.ecommerce

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BagItemViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(com.example.ecommerce.R.layout.bag_item, parent, false)) {
    var item_name: TextView
    var item_price: TextView
    var item_ref: TextView
    var item_image: ImageView


    init {
        item_name = itemView.findViewById(com.example.ecommerce.R.id.item_name)
        item_price = itemView.findViewById(com.example.ecommerce.R.id.item_price)
        item_ref = itemView.findViewById(com.example.ecommerce.R.id.item_ref)
        item_image = itemView.findViewById(com.example.ecommerce.R.id.item_image)
    }

    fun bind(bagItem: BagItem) {
        item_name.text = bagItem.item_name
        item_price.text = bagItem.item_price
        item_ref.text = bagItem.item_ref
        item_image.setImageResource(com.example.ecommerce.R.drawable.img_watch)
    }
}
