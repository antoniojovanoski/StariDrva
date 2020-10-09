package com.gsixacademy.android.staridrva.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gsixacademy.android.staridrva.R
import com.gsixacademy.android.staridrva.data.TreeData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tree_list_row.view.*


class TreesAdapter(
    val treesData: ArrayList<TreeData>,
    val monumentalTrees: ArrayList<Int>,
   val treesAdapterClickEvent: (TreesAdapterClickEvent) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.tree_list_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return treesData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val myViewHolder = holder as MyViewHolder
        myViewHolder.bindData(treesData[position], position)
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(treesData: TreeData, position: Int) {
            itemView.text_view_name.text = treesData.name
            itemView.text_view_location.text = treesData.locality
            itemView.text_view_height.text = treesData.height
            itemView.text_view_age.text = treesData.age
            itemView.image_view_monumental.visibility=if (isOneOfMonumentalTrees(treesData.id)) View.VISIBLE else View.INVISIBLE
            if (treesData.images != null && treesData.images!!.isNotEmpty()) {
                Picasso.get().load(treesData.images!![0]).centerCrop().fit()
                    .into(itemView.image_view_thubmnail)
            }
            itemView.constraint_layout_main.setOnClickListener{
                treesAdapterClickEvent.invoke(TreesAdapterClickEvent.TreesAdapterItemClicked(treesData))

            }        }

    }

    fun isOneOfMonumentalTrees(treeId: Int): Boolean {
        for (id in monumentalTrees) {
            if (id == treeId)
                return true
        }
        return false
    }
}