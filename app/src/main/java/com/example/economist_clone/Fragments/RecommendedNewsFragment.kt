package com.example.economist_clone.Fragments

import android.media.MediaPlayer.OnCompletionListener
import android.media.MediaPlayer.OnPreparedListener
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.economist_clone.R
import kotlinx.android.synthetic.main.recommended_news.*


class RecommendedNewsFragment : Fragment(R.layout.recommended_news) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = arguments?.getString("video")

        NewsVideoView.setVideoPath(url)

        NewsVideoView.setOnPreparedListener(OnPreparedListener { mediaPlayer -> mediaPlayer.start() })

        NewsVideoView.setOnCompletionListener(OnCompletionListener { mediaPlayer -> mediaPlayer.start() })

    }
}