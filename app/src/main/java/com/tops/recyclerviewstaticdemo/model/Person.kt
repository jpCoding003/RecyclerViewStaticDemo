package com.tops.recyclerviewstaticdemo.model

import java.io.Serializable

data class Person (
    val name: String,
    val age: Int,
    val pic: Int
):java.io.Serializable // serializing the model