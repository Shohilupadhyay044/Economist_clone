package com.example.economist_clone.Adapter

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.economist_clone.Fragments.YoutubePlayerSupportFragmentsDirections
import com.example.economist_clone.R
import com.example.economist_clone.models.LiveNews
import kotlinx.android.synthetic.main.item_live_news.view.*

class LiveNewsholder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun set(liveNews: LiveNews){

        itemView.apply {

            Glide.with(ivImage).load(liveNews.videoImage).into(ivImage)

            tvTitle.text = liveNews.videoTitle

            tvTime.text = liveNews.VideoTime


            ivPlayButton.setOnClickListener {

                    val bundle = bundleOf("video" to liveNews.VideoUrl)
                findNavController().navigate(R.id.action_youtubePlayerSupportFragments_to_recommendedNewsFragment
                ,bundle)
            }
        }
    }
}