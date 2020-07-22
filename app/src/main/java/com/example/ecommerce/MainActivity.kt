package com.example.ecommerce

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var addToBagBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addToBagBtn = findViewById(R.id.add_to_bag)
        addToBagBtn.setOnClickListener {
            intent = Intent(applicationContext, BagItemsActivity::class.java)
            startActivity(intent)
        }
    }
}
