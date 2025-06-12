package com.tops.recyclerviewstaticdemo

import com.tops.recyclerviewstaticdemo.model.Person

object Constant{

    fun getPersonData(): ArrayList<Person>{
        // create an arraylist of type [person] class
        val personList: MutableList<Person> = ArrayList()
        personList.add(
            Person(
                "Jay",
                22,
                R.drawable.jay
            )
        )
        personList.add(
            Person(
                "Smit",
                35,
                R.drawable.img
            )
        )
        personList.add(
            Person(
                "Axay",
                32,
                R.drawable.qwert
            )
        )
        personList.add(
            Person(
                "Aryan",
                16,
                R.drawable.image22
            )
        )
        personList.add(
            Person(
                "Jayloo Pacho",
                26,
                R.drawable.download
            )
        )
        return personList as ArrayList<Person>
    }
}