package com.example.economist_clone.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.economist_clone.R
import com.example.economist_clone.models.LiveNews

class LiveNewsAdapter( private  val VideoList: MutableList<LiveNews>) : RecyclerView.Adapter<LiveNewsholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveNewsholder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_live_news,parent,false)

        return LiveNewsholder(view)

    }

    override fun onBindViewHolder(holder: LiveNewsholder, position: Int) {

        val model = VideoList[position]

        holder.set(model)

    }

    override fun getItemCount(): Int {

        return VideoList.size

    }
}