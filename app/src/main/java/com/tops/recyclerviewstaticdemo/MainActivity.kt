package com.tops.recyclerviewstaticdemo

import android.net.eap.EapSessionConfig
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tops.recyclerviewstaticdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
         binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val examlist: MutableList<ExamItem> = ArrayList()
        examlist.add(
            ExamItem(
                "Jay",
                22,
                R.drawable.jay
            )
        )
        examlist.add(
            ExamItem(
                "Smit",
                35,
                R.drawable.img
            )
        )
        examlist.add(
            ExamItem(
                "Axay",
                32,
                R.drawable.qwert
            )
        )
        examlist.add(
            ExamItem(
                "Aryan",
                16,
                R.drawable.image22
            )
        )
        examlist.add(
            ExamItem(
                "Jayloo Pacho",
                26,
                R.drawable.download
            )
        )
       binding.rvData.layoutManager = LinearLayoutManager(this)

        val adapter = MyAdapter(examlist)
        binding.rvData.adapter = adapter
    }
}