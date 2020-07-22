package com.example.ecommerce

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class BagItemsActivity : AppCompatActivity() {

    private var mBagItems : MutableList<BagItem> = mutableListOf(
        BagItem(
            "Tudor Black bay",
            "658.0",
            "Reference: m79540-0006",
            "drawable/img_watch.png"
        ),
        BagItem(
            "Tudor Black bay",
            "658.0",
            "Reference: m79540-0006",
            "drawable/img_watch.png"
        ),
        BagItem(
            "Tudor Black bay",
            "658.0",
            "Reference: m79540-0006",
            "drawable/img_watch.png"
        )
    )
    private lateinit var bagItemsRecyclerview : RecyclerView
    private lateinit var price : TextView


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
        supportActionBar?.setCustomView(R.layout.toolbar_layout);
        setContentView(R.layout.activity_bag_items)


        price = findViewById(R.id.price)
        bagItemsRecyclerview = findViewById(R.id.bag_items_recyclerview)
        bagItemsRecyclerview.apply {
            adapter = BagItemAdapter(mBagItems,context)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            bagItemsRecyclerview.layoutManager = layoutManager
        }
        val sharedPref = applicationContext.getSharedPreferences("Shared Pref", Context.MODE_PRIVATE)
        price.text = "$"+ sharedPref.getFloat("Total Price",0F).toString()

    }

    fun toMainActivity(view: View) {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }


}
