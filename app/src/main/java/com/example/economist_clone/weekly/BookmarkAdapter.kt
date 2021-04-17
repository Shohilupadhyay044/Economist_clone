package com.example.economist_clone.weekly

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.economist_clone.R
import com.example.economist_clone.saveddatabase.MyDatabase
import com.example.economist_clone.saveddatabase.MyEntity
import kotlinx.android.synthetic.main.saved_item_layout.view.*

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookmarkAdapter(val responseList:List<MyEntity>):RecyclerView.Adapter<BookmarkAdapter.BookmarkHolder>() {

    class BookmarkHolder(view: View):RecyclerView.ViewHolder(view){
        var tvSubItemTitle: TextView = view.findViewById(R.id.tv_saved_sub_item_title)
        var tvDescription: TextView =view.findViewById(R.id.tv_saved_Description)
        var img_sub_item: ImageView =view.findViewById(R.id.img_saved_sub_item)
        var img_save: ImageView =view.findViewById(R.id.img_saved_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.saved_item_layout, parent, false)
        return BookmarkHolder(view)
    }

    override fun onBindViewHolder(holder: BookmarkHolder, position: Int) {
        val subItem= responseList[position]
        holder.tvSubItemTitle.text = subItem.title
        holder.tvDescription.text=subItem.author
        Glide.with(holder.img_sub_item).load(subItem.urlToImage).into(holder.img_sub_item)
        val database= MyDatabase.getDatabase(holder.itemView.context).getMyDao()
        holder.itemView.img_saved_btn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                database.deleteDetails(subItem.id)
                holder.itemView.img_saved_btn.setImageResource(R.drawable.save_first)
            }

        }
    }

    override fun getItemCount(): Int {
        return responseList.size
    }
}