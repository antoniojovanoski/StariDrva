package com.gsixacademy.android.staridrva.adapters

import com.gsixacademy.android.staridrva.data.TreeData

sealed class TreesAdapterClickEvent {
     data class TreesAdapterItemClicked(val treeData : TreeData):TreesAdapterClickEvent()
}