package com.example.enozomtask.emp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.enozomtask.addEmp.viewModel.AddEmpViewModel
import com.example.enozomtask.model.RepoInterface




class EmpViewModelFactory (private val repo : RepoInterface) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(EmpViewModel::class.java)){
            EmpViewModel(repo) as T
        }else{
            throw IllegalArgumentException("view model class not found")
        }
    }
}