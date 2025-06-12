package com.tops.recyclerviewstaticdemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tops.recyclerviewstaticdemo.databinding.ActivityPersonDetailsBinding
import com.tops.recyclerviewstaticdemo.model.Person

class PersonDetails : AppCompatActivity() {
    private lateinit var binding: ActivityPersonDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonDetailsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        var personlist: Person? =null

        if (intent.hasExtra(MainActivity.NEXT_SCREEN)){
            // get the Serializable data model class with the details in it
            personlist= intent.getSerializableExtra(MainActivity.NEXT_SCREEN) as Person?

        }

        if(personlist!=null){
            binding?.cardName1?.text = personlist!!.name
            binding?.cardAge1?.text = personlist!!.age.toString()
            binding?.imageCard1?.setImageResource(personlist!!.pic)

        }

    }
}