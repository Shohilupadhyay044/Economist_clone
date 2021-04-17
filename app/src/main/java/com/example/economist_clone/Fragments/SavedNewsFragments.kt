package com.example.economist_clone.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.economist_clone.R
import com.example.economist_clone.saveddatabase.MyDatabase
import com.example.economist_clone.saveddatabase.MyEntity
import com.example.economist_clone.weekly.BookmarkAdapter
import kotlinx.android.synthetic.main.fragment_saved.*

class SavedNewsFragments : Fragment(R.layout.fragment_saved) {
    private var headerList: MutableList<MyEntity> = mutableListOf()

    private lateinit var bookmarkAdapter: BookmarkAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        bookmarkAdapter = BookmarkAdapter(headerList)
        rvBookmark.adapter = bookmarkAdapter
        rvBookmark.layoutManager = layoutManager
        context?.let {
            val database = MyDatabase.getDatabase(it).getMyDao()
            database.getAllDetails().observe(viewLifecycleOwner, Observer {
                headerList.clear()
                headerList.addAll(it)
                bookmarkAdapter.notifyDataSetChanged()
            })

        }
    }
}