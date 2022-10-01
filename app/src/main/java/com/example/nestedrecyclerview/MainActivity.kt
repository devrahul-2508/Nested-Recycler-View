package com.example.nestedrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nestedrecyclerview.databinding.ActivityMainBinding
import com.example.nestedrecyclerview.models.ChildModel
import com.example.nestedrecyclerview.models.ParentModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var parentAdapter: ParentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val parentModels : ArrayList<ParentModel> = arrayListOf()
        val childModels  : ArrayList<ChildModel> = arrayListOf()

        childModels.add(ChildModel("India"))
        childModels.add(ChildModel("America"))
        childModels.add(ChildModel("Usa"))
        childModels.add(ChildModel("Russia"))
        childModels.add(ChildModel("Sri Lanka"))

        parentModels.add(ParentModel("Country"))
        parentModels.add(ParentModel("Continent"))
        parentModels.add(ParentModel("Asia",childModels))
        parentModels.add(ParentModel("Northern Hemisphere"))
        parentModels.add(ParentModel("Southern Hemisphere"))
        parentModels.add(ParentModel("Tropic of Cancer",childModels))
        parentModels.add(ParentModel("Tropic of Capricon",childModels))
        parentModels.add(ParentModel("North Pole"))
        parentModels.add(ParentModel("South Pole"))

        parentAdapter = ParentAdapter(parentModels,this)

        binding.parentRV.layoutManager = LinearLayoutManager(this)
        binding.parentRV.adapter = parentAdapter





    }
}