package com.tops.recyclerviewstaticdemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.tops.recyclerviewstaticdemo.databinding.ActivityMainBinding
import com.tops.recyclerviewstaticdemo.model.Person

class MainActivity : AppCompatActivity() {

    // Guide:  Apply_RecyclerView_OnClickListenre_to_recycler_item
    // Below::-----
    // link->      https://www.geeksforgeeks.org/how-to-apply-onclicklistener-to-recyclerview-items-in-android/

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


        val personlist = Constant.getPersonData()
       binding.rvData.layoutManager = LinearLayoutManager(this)


        binding?.rvData?.setHasFixedSize(true)


        val adapter = MyAdapter(personlist)
        // Assign ItemAdapter instance to our RecylerView
        binding.rvData.adapter = adapter



        adapter.setOnClickListener(object: MyAdapter.OnClickListener{
            override fun onClick(position: Int, model: Person) {
                val intent = Intent(this@MainActivity, PersonDetails::class.java)
                // Passing the data to the
                // EmployeeDetails Activity

                //for putExtra()  Serilizing the model is important
                intent.putExtra(NEXT_SCREEN, model)

                startActivity(intent)
            }
        })
    }

    companion object{
        val NEXT_SCREEN="details_screen"
    }
}