package com.gsixacademy.android.staridrva.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gsixacademy.android.staridrva.R
import com.gsixacademy.android.staridrva.adapters.ViewPagerAdapter
import com.gsixacademy.android.staridrva.data.TreeData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_tree_details.*

class TreeDetailsFragment : Fragment() {

    lateinit var treeData: TreeData
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tree_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        treeData = arguments?.get("treeData") as TreeData


        view__pager_tree.adapter = treeData.images?.let { ViewPagerAdapter(it) }
        text_view_name_value.text = treeData.name
        text_view_latin_name_value.text = treeData.name
        text_view_height_value.text = "${treeData.height}m"
        text_view_location_value.text = treeData.locality
        text_view_age_value.text = "${treeData.age} years"

    }
}