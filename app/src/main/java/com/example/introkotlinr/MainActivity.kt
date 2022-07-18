package com.example.introkotlinr

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator

class MainActivity : AppCompatActivity() {

    var titliList = mutableListOf<String>()
    var descList = mutableListOf<String>()
    var lottieList = mutableListOf<String>()

    lateinit var recyclerview: RecyclerView
    lateinit var skip: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview = findViewById(R.id.recyclerview)

        postToList()

        recyclerview.adapter = Adapter(titliList, descList, lottieList)
        recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        var snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerview)


        val recyclerIndicator: ScrollingPagerIndicator = findViewById(R.id.indicator)
        recyclerIndicator.attachToRecyclerView(recyclerview)

        var started: Button = findViewById(R.id.started)
        skip = findViewById(R.id.skip)
        var a = 0
        skip.setOnClickListener {

            if (a == 0) {
                a++
                recyclerview.scrollToPosition(a)

            } else if (a == 1) {
                a++
                recyclerview.scrollToPosition(a)
                skip.visibility = View.GONE
                started.visibility = View.VISIBLE

            } else if (a == 2) {
                recyclerview.scrollToPosition(a)
            }
        }
    }

    fun addtoList(title: String, detail: String, lottie: String) {

        titliList.add(title)
        descList.add(detail)
        lottieList.add(lottie)
    }

    fun postToList() {

        var title1 = "  Say Hello to \nGlobal Top-Up"
        var abaut1 = "Send mobile  top-up tomore than 500 networks     \n " +
                "                        in over 140 countries"
        var title2 = "Safe, Trusted & \n   Fully Secure "
        var abaut2 = "Encrypted transactions mean  your  payments & \n                       Privacy and protected"
        var title3 = "Easy to Use"
        var abaut3 = "Pick a number , choose an amount, send your \n                             Top-up. Simple"
        var titleArray = ArrayList<String>()
        titleArray.add(title1)
        titleArray.add(title2)
        titleArray.add(title3)
        var abautArray = ArrayList<String>()
        abautArray.add(abaut1)
        abautArray.add(abaut2)
        abautArray.add(abaut3)
        for (i in 0..2 step 1) {
            addtoList(titleArray[i], abautArray[i], "a$i.json")
        }
      //  window.statusBarColor=ContextCompat.getColor(this,R.color.white)
    }
}