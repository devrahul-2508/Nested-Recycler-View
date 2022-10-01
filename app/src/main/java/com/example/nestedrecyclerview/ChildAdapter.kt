package com.example.nestedrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.databinding.ItemChildLayoutBinding
import com.example.nestedrecyclerview.models.ChildModel

class ChildAdapter(private val childList: List<ChildModel>): RecyclerView.Adapter<ChildAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_child_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding){
            val item = childList[position]
            childLabel.text = item.title

        }
    }

    override fun getItemCount(): Int {
        return childList.size
}

    inner class ViewHolder(val binding: ItemChildLayoutBinding): RecyclerView.ViewHolder(binding.root)
}