package com.example.economist_clone.weekly

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.economist_clone.R
import kotlinx.android.synthetic.main.fragment_weekly.*

class WeeklyNewsFragments : Fragment(R.layout.fragment_weekly) {
    private var responseList:MutableList<ResponseModel> = mutableListOf()
    private lateinit var itemAdapter: ItemAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        itemAdapter = ItemAdapter(responseList)
        rv_item.adapter = itemAdapter
        rv_item.layoutManager = layoutManager

        callViewModel()
        BtnAlign.setOnClickListener {
            val action=WeeklyNewsFragmentsDirections.actionGlobalSectionFragment()
            findNavController().navigate(action)
        }
    }

    private fun callViewModel() {
        val viewModel: MyViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
         viewModel.getData().observe(viewLifecycleOwner, Observer {
//             Log.d("tag", "callViewModel: "+ it[0].details?.get(0)?.urlToImage.toString())
             responseList.addAll(it)
             itemAdapter.notifyDataSetChanged()
         })
    }




}