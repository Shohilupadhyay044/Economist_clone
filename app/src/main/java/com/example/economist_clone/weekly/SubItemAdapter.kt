package com.example.economist_clone.weekly

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.economist_clone.R


open class SubItemAdapter (val subItemList: List<DetailsModel>) :
        RecyclerView.Adapter<SubItemAdapter.SubItemViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): SubItemViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.details_item_layout, viewGroup, false)
        return SubItemViewHolder(view)
    }

    override fun onBindViewHolder(subItemViewHolder: SubItemViewHolder, i: Int) {
        val subItem: DetailsModel = subItemList[i]
        subItemViewHolder.tvSubItemTitle.setText(subItem.title)
        subItemViewHolder.tvDescription.text=subItem.author
        Glide.with(subItemViewHolder.img_sub_item).load(subItem.urlToImage).into(subItemViewHolder.img_sub_item)
    }

    override fun getItemCount(): Int {
        return subItemList.size
    }

    class SubItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvSubItemTitle: TextView= itemView.findViewById(R.id.tv_sub_item_title)
        var tvDescription: TextView=itemView.findViewById(R.id.tvDescription)
        var img_sub_item:ImageView=itemView.findViewById(R.id.img_sub_item)

    }

}