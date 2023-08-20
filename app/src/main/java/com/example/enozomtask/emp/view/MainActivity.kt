package com.example.enozomtask.emp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.enozomtask.R
import com.example.enozomtask.addEmp.view.AddActivity
import com.example.enozomtask.addEmp.viewModel.AddEmpViewModel
import com.example.enozomtask.addEmp.viewModel.AddEmpViewModelFactory
import com.example.enozomtask.database.LocalSourceImp
import com.example.enozomtask.emp.viewModel.EmpViewModel
import com.example.enozomtask.emp.viewModel.EmpViewModelFactory
import com.example.enozomtask.model.Emp
import com.example.enozomtask.model.Repositry
import com.example.enozomtask.model.Skills

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    lateinit var empViewModel: EmpViewModel
    lateinit var empViewModelFactory: EmpViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        empViewModelFactory = EmpViewModelFactory(
            Repositry.getInstance(
                LocalSourceImp(this)
            )
        )
        empViewModel =
            ViewModelProvider(this, empViewModelFactory).get(EmpViewModel::class.java)
        // Initialize RecyclerView
        recyclerView = findViewById(R.id.emp_rec)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val skill1 = Skills(1,"c++")
        empViewModel.addSkill(skill1)
        val skill2 = Skills(2,"java")
        empViewModel.addSkill(skill2)
        val skill3 = Skills(3,"c#")
        empViewModel.addSkill(skill3)

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