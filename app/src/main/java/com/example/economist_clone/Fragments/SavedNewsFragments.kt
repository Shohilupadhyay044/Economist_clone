package com.example.economist_clone.Fragments

import android.graphics.Canvas
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androiddevs.mvvmnewsapp.ui.NewsViewModel
import com.example.economist_clone.Adapter.NewsAdapter
import com.example.economist_clone.MainActivity
import com.example.economist_clone.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_saved.*

import com.example.economist_clone.saveddatabase.MyDatabase
import com.example.economist_clone.saveddatabase.MyEntity
import com.example.economist_clone.weekly.BookmarkAdapter
import kotlinx.android.synthetic.main.fragment_saved.*

class SavedNewsFragments : Fragment(R.layout.fragment_saved){

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    private var headerList: MutableList<MyEntity> = mutableListOf()

    private lateinit var bookmarkAdapter: BookmarkAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()

        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                    R.id.action_savedNewsFragments_to_articleFragment2,
                    bundle
            )
        }

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP or ItemTouchHelper.DOWN,
                ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val article = newsAdapter.differ.currentList[position]
                viewModel.deleteArticle(article)
                Snackbar.make(view, "Successfully deleted article", Snackbar.LENGTH_LONG).apply {
                    setAction("Undo") {
                        viewModel.saveArticle(article)
                    }
                    show()
                }
            }

        }

        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(rvSavedNews)

        }



        viewModel.getSavedNews().observe(viewLifecycleOwner, Observer { articles ->
            newsAdapter.differ.submitList(articles)
        })
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        rvSavedNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
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