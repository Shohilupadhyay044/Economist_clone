package com.example.economist_clone.weekly
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.example.economist_clone.R


class ItemAdapter (private val itemList: List<ResponseModel>) :
        RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    val viewPool = RecycledViewPool()
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ItemViewHolder {
        val view: View =
                LayoutInflater.from(viewGroup.context).inflate(R.layout.heading_item_lauout, viewGroup, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(itemViewHolder: ItemViewHolder, i: Int) {
        val item: ResponseModel = itemList[i]
        itemViewHolder.tvItemTitle.text = item.header

        // Create layout manager with initial prefetch item count
        val layoutManager = LinearLayoutManager(itemViewHolder.rvSubItem.context, LinearLayoutManager.VERTICAL, false
        )
        layoutManager.initialPrefetchItemCount = item.details?.size!!

        // Create sub item view adapter
        val subItemAdapter = SubItemAdapter(item.details as List<DetailsModel>)
        itemViewHolder.rvSubItem.layoutManager = layoutManager
        itemViewHolder.rvSubItem.adapter = subItemAdapter
        itemViewHolder.rvSubItem.setRecycledViewPool(viewPool)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ItemViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
        val tvItemTitle: TextView
        val rvSubItem: RecyclerView

        init {
            tvItemTitle = itemView.findViewById(R.id.tv_item_title)
            rvSubItem = itemView.findViewById(R.id.rv_sub_item)
        }
    }
}