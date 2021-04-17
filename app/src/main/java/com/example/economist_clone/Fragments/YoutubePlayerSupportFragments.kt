package com.example.economist_clone.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.economist_clone.Adapter.LiveNewsAdapter
import com.example.economist_clone.R
import com.example.economist_clone.models.LiveNews
import kotlinx.android.synthetic.main.youtube_player_support.*


class YoutubePlayerSupportFragments : Fragment(R.layout.youtube_player_support)
{
    private val VideoList = mutableListOf<LiveNews>()

    lateinit var liveNewsAdapter: LiveNewsAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buildData()

        setRecyclerAdapter()
    }
    private fun setRecyclerAdapter() {
        liveNewsAdapter = LiveNewsAdapter(VideoList)

        var linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvLiveNews.layoutManager =linearLayoutManager
        rvLiveNews.adapter =liveNewsAdapter
    }

    private fun buildData() {

        VideoList.add(
            LiveNews(
                "https://firebasestorage.googleapis.com/v0/b/shivam-8f1e0.appspot.com/o/yt1s.com%20-%20Explained%20Why%20the%20sudden%20shortage%20of%20Remdesivir%20and%20the%20way%20forward_v240P.mp4?alt=media&token=575cac10-6e26-4550-8159-bffb84165727",
                "2 hours ago",
                "https://img.etimg.com/thumb/msid-82076214,width-294,resizemode-4,imgsize-276016/coronavirus-news-and-updates-live-april-15.jpg",
                "Explained: Why the sudden shortage of Remdesivir and the way forward"
            )
        )

        VideoList.add(
            LiveNews(
                "https://firebasestorage.googleapis.com/v0/b/shivam-8f1e0.appspot.com/o/yt1s.com%20-%20Cyclone%20Fani%20batters%20Odisha%20Dramatic%20visuals%20%20Economic%20Times_360p.mp4?alt=media&token=d5408fb3-8e73-46b8-84b8-f43abe5cae1e",
                "4 hours ago",
                "https://img.etimg.com/thumb/msid-69161193,width-445,resizemode-4,imgsize-181529/cyclone-fani-landfall-in-odisha-here-is-all-that-you-need-to-know.jpg",
                "Cyclone Fani batters Odisha: Dramatic visuals | Economic Times"
            )
        )
        VideoList.add(
            LiveNews(
                "https://firebasestorage.googleapis.com/v0/b/shivam-8f1e0.appspot.com/o/yt1s.com%20-%20Sputnik%20V%20Vaccine%20How%20effective%20could%20Indias%20third%20Covid19%20vaccine%20be_v240P.mp4?alt=media&token=64713b1a-c89c-4fd4-9ab6-7f0d8d5e3a0c",
                "19 hours ago",
                "https://images.livemint.com/img/2021/04/12/600x338/AFP_97J3U3_1618227326985_1618227406153.jpg",
                "Sputnik V Vaccine: How effective could India’s third Covid-19 vaccine be?"
            )
        )
        VideoList.add(
            LiveNews(
                "https://firebasestorage.googleapis.com/v0/b/shivam-8f1e0.appspot.com/o/yt1s.com%20-%20Maharashtra%20No%20lockdown%20but%20strict%20curbs%20imposed%20from%20April%2014%20including%20Sec%20144%20says%20CM%20Thackeray_v240P.mp4?alt=media&token=0734e2ef-73a2-4973-880e-f82880473313",
                "5 days ago ",
                "https://images.hindustantimes.com/img/2021/04/13/550x309/5a248b3a-658c-11eb-b803-eb9771c75b08_1618334406566_1618334428621.jpg",
                "Maharashtra: No lockdown but strict curbs imposed from April 14 including Sec 144, says CM Thackeray"
            )
        )
    }
}
