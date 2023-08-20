package com.example.enozomtask.addEmp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.enozomtask.R
import com.example.enozomtask.addEmp.viewModel.AddEmpViewModel
import com.example.enozomtask.addEmp.viewModel.AddEmpViewModelFactory
import com.example.enozomtask.database.LocalSourceImp
import com.example.enozomtask.model.Emp
import com.example.enozomtask.model.Repositry
import com.example.enozomtask.model.Skills
import com.google.android.material.textfield.TextInputEditText

class AddActivity : AppCompatActivity() {
    lateinit var empViewModel: AddEmpViewModel
    lateinit var empViewModelFactory: AddEmpViewModelFactory
    private lateinit var skillsRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)


        empViewModelFactory = AddEmpViewModelFactory(
            Repositry.getInstance(
                LocalSourceImp(this)
            )
        )
        empViewModel =
            ViewModelProvider(this, empViewModelFactory).get(AddEmpViewModel::class.java)
        val emp = Emp("","","")
        val buttonAdd = findViewById<Button>(R.id.save)
        val editTextEmail = findViewById<TextInputEditText>(R.id.user_email)
        val editTextName = findViewById<EditText>(R.id.name_text)

       /* if (emp != null) {
            emp.name = name
        }
        if (emp != null) {
            emp.email = email
        }*/

              buttonAdd.setOnClickListener {
                  if (emp != null) {
                      val email = editTextEmail.text.toString()
                      val name = editTextName.text.toString()
                      emp.name = name
                      emp.email = email
                      empViewModel.addEmp(emp)
                      print("sucess in database")
                      Log.i("email", email)
                      Log.i("name", name)
                  }


              }
        //skillsRecyclerView = findViewById(R.id.skillsRecyclerView)
       // skillsRecyclerView.adapter = SkillAdapter(getDummySkills())

    }
    private fun getDummySkills(): List<Skills> {
        return listOf(
            Skills(1, "Programming"),
            Skills(2, "Design"),
            Skills(3, "Communication")
            // Add more skills here
        )
    }
}