package com.example.economist_clone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.economist_clone.weekly.ItemAdapter
import com.example.economist_clone.weekly.MyViewModel
import com.example.economist_clone.weekly.ResponseModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_section.*
import kotlinx.android.synthetic.main.fragment_weekly.*


class SectionFragment : BottomSheetDialogFragment() {

    private var responseList:MutableList<ResponseModel> = mutableListOf()
    private lateinit var bottomHeadingAdapter: BottomHeadingAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_section, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        bottomHeadingAdapter = BottomHeadingAdapter(responseList)
        RvSection.adapter = bottomHeadingAdapter
        RvSection.layoutManager = layoutManager
        callViewModel()
    }

    private fun callViewModel() {
        val viewModel: MyViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        viewModel.getData().observe(viewLifecycleOwner, Observer {
            responseList.addAll(it)
            bottomHeadingAdapter.notifyDataSetChanged()
        })
    }

}