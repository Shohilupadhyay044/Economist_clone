package com.example.economist_clone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.economist_clone.weekly.ResponseModel
import kotlinx.android.synthetic.main.section_item_layout.view.*


class BottomHeadingAdapter(var headerList:List<ResponseModel>):
    RecyclerView.Adapter<BottomHeadingAdapter.BottomViewHolder>() {
    inner class BottomViewHolder(view:View):RecyclerView.ViewHolder(view){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.section_item_layout, parent,
            false)
        return BottomViewHolder(view)
    }

    override fun onBindViewHolder(holder: BottomViewHolder, position: Int) {
        holder.itemView.tv_h_rv_title.text=headerList[position].header

    }

    override fun getItemCount(): Int {
        return headerList.size
    }
}