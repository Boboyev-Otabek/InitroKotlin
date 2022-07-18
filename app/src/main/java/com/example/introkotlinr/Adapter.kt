package com.example.introkotlinr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView

class Adapter(
    var title: List<String>,
    var details: List<String>,
    var lottie: MutableList<String>
) :
    RecyclerView.Adapter<Adapter.Pagerholder>() {

    class Pagerholder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var itemtitle: TextView = itemview.findViewById(R.id.text_title)
        var itemdetail: TextView = itemview.findViewById(R.id.txt_abaut)
        var itemlottie: LottieAnimationView = itemview.findViewById(R.id.lotti)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pagerholder {
        return Pagerholder(LayoutInflater.from(parent.context).inflate(R.layout.activity_item,parent,false))
    }

    override fun onBindViewHolder(holder: Pagerholder, position: Int) {
        holder.itemtitle.text=title[position]
        holder.itemdetail.text=details[position]
        holder.itemlottie.setAnimation(lottie[position])
    }

    override fun getItemCount(): Int {
        return title.size
    }
}