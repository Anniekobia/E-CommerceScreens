package com.example.ecommerce

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {

    private lateinit var addToBagBtn : Button
    lateinit var viewPager: ViewPager
    lateinit var tabs: TabLayout
    var images = intArrayOf(R.drawable.img_watch, R.drawable.img_watch, R.drawable.img_watch)
    var myCustomPagerAdapter: MyCustomPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        image viewpager
        viewPager = findViewById(R.id.item_image_Viewpager)
        tabs = findViewById(R.id.tab_layout)
        myCustomPagerAdapter = MyCustomPagerAdapter(this, images)
        viewPager!!.adapter = myCustomPagerAdapter
        tabs.setupWithViewPager(viewPager)

//        Spacing between tabs
        for (i in 0 until tabs.tabCount) {
            val tab = (tabs.getChildAt(0) as ViewGroup).getChildAt(i)
            val p = tab.layoutParams as MarginLayoutParams
            p.setMargins(0, 0, 10, 0)
            tab.requestLayout()
        }

        addToBagBtn = findViewById(R.id.add_to_bag)
        addToBagBtn.setOnClickListener {
            intent = Intent(applicationContext, BagItemsActivity::class.java)
            startActivity(intent)
        }
    }
}

class MyCustomPagerAdapter(context: Context, images: IntArray) :
    PagerAdapter() {
    var context: Context
    var images: IntArray
    var layoutInflater: LayoutInflater

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView: View = layoutInflater.inflate(R.layout.watch_layout, container, false)
        val imageView: ImageView = itemView.findViewById(R.id.item_image) as ImageView
        imageView.setImageResource(images[position])
        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        `object`: Any
    ) {
        container.removeView(`object` as LinearLayout)
    }

    init {
        this.context = context
        this.images = images
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
}
