package com.example.enozomtask.addEmp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.enozomtask.model.RepoInterface


class AddEmpViewModelFactory (private val repo : RepoInterface) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(AddEmpViewModel::class.java)){
            AddEmpViewModel(repo) as T
        }else{
            throw IllegalArgumentException("view model class not found")
        }
    }
}