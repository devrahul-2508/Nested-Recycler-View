package com.example.nestedrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.nestedrecyclerview.databinding.ItemMainLayoutBinding
import com.example.nestedrecyclerview.databinding.ItemParentLayoutBinding
import com.example.nestedrecyclerview.models.ParentModel

class ParentAdapter(private val parentModels: List<ParentModel>,private val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            1->{
                MainViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_main_layout,parent,false))
            }
            else ->{
                ChildViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_parent_layout,parent,false))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = parentModels[position]
       when(holder.itemViewType){
           1->{
              val h = holder as MainViewHolder
               h.binding1.parentLabel.text = item.title
           }
           2->{
               val h = holder as ChildViewHolder
               val adapter = ChildAdapter(item.childList!!)
               h.binding2.childRV.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
               h.binding2.childRV.adapter = adapter
           }
       }
    }

    override fun getItemCount(): Int {
        return parentModels.size
    }

    override fun getItemViewType(position: Int): Int {
        //return super.getItemViewType(position)
        val item = parentModels[position]
        return if (item.childList == null){
            1
        } else{
            2
        }
    }







    inner class MainViewHolder(val binding1: ItemMainLayoutBinding): RecyclerView.ViewHolder(binding1.root)

    inner class ChildViewHolder(val binding2: ItemParentLayoutBinding): RecyclerView.ViewHolder(binding2.root)




}