package com.example.enozomtask.emp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.enozomtask.R
import com.example.enozomtask.addEmp.AddActivity

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.emp_rec)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Create and set the adapter

        val data = listOf(
            Pair("Item 1", R.drawable.emp),
            Pair("Item 2", R.drawable.emp),
            Pair("Item 3", R.drawable.emp),
            Pair("Item 4", R.drawable.emp),
            Pair("Item 5", R.drawable.emp)
        )
        adapter = MyAdapter(data)
        recyclerView.adapter = adapter
        val button = findViewById<Button>(R.id.add)
        button.setOnClickListener {
                val intent = Intent(this, AddActivity::class.java)
                startActivity(intent)

        }
    }
}