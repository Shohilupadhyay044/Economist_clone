package com.example.economist_clone.weekly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.economist_clone.R
import kotlinx.android.synthetic.main.activity_description.*

class DescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        if (intent!=null){
            tvTitle.text= intent.getStringExtra("title").toString()
            tvTextDes.text= intent.getStringExtra("description").toString()
            Glide.with(ivImage).load(intent.getStringExtra("pic")).into(ivImage)

        }

    }
}