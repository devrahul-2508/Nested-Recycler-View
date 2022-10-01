package com.example.nestedrecyclerview.models

data class ParentModel(
    var title: String?=null,
    var childList: List<ChildModel>?=null
)