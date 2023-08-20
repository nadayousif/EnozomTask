package com.example.enozomtask.addEmp.view

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.enozomtask.R
import com.example.enozomtask.addEmp.viewModel.AddEmpViewModel
import com.example.enozomtask.addEmp.viewModel.AddEmpViewModelFactory
import com.example.enozomtask.database.LocalSourceImp
import com.example.enozomtask.model.Emp
import com.example.enozomtask.model.Repositry
import com.google.android.material.textfield.TextInputEditText

class AddActivity : AppCompatActivity() {
    lateinit var empViewModel: AddEmpViewModel
    lateinit var empViewModelFactory: AddEmpViewModelFactory
    private lateinit var skillsRecyclerView: RecyclerView

    private lateinit var autoCompleteTextView: AutoCompleteTextView
    private lateinit var autoCompleteAdapter: AutoCompleteAdapter
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
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView) // Initialize the autoCompleteTextView
        autoCompleteAdapter = AutoCompleteAdapter(this, getSkillsFromDatabase())
        autoCompleteTextView.setAdapter(autoCompleteAdapter)

       /* var data = arrayOf("c", "c++", "Java")

        val adapter
                = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, data)
        autotextView.setAdapter(adapter)*/




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
      /*  empViewModel.getSkill().observe(this, { skillsList ->
            autoCompleteAdapter.setData(skillsList)
        })
        autoCompleteTextView.setOnItemClickListener { _, _, position, _ ->
            val selectedSkill = autoCompleteAdapter.getItem(position)
            // Do something with the selected skill (e.g., display details)
        }*/


    }
    private fun getSkillsFromDatabase(): List<String> {
        // Code to retrieve skills from the database and convert them to a list of strings
        // For example, using Room's query
        var nada : String
        nada = empViewModel.getSkill().toString()
        val skillsList: List<String> =  listOf("c", "c++", "java")
        return skillsList.map { it }
    }

}