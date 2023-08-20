package com.example.enozomtask.emp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.enozomtask.R

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
    }
}