package com.gsixacademy.android.staridrva.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gsixacademy.android.staridrva.MainActivity
import com.gsixacademy.android.staridrva.R
import com.gsixacademy.android.staridrva.adapters.TreesAdapter
import com.gsixacademy.android.staridrva.adapters.TreesAdapterClickEvent
import com.gsixacademy.android.staridrva.data.TreeData
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment:Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
    }

   private fun initRecyclerView() {

       var treeListModel = (activity as MainActivity).treeListModel
       recycler_view_main.adapter = treeListModel?.trees?.let {trees ->
           treeListModel.monumental_trees?.let { monumentalTrees ->
               TreesAdapter(trees, monumentalTrees){
                   if (it is TreesAdapterClickEvent.TreesAdapterItemClicked) {
                      var bundle = Bundle()
                       bundle.putParcelable("treeData", it.treeData)
                       findNavController().navigate(R.id.action_listFragment_to_treeDetailsFragment,bundle)
                   }
               }
           }
       }
    }
}