package com.example.enozomtask.addEmp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.enozomtask.model.Emp
import com.example.enozomtask.model.RepoInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class AddEmpViewModel (private val _repo : RepoInterface): ViewModel() {
    private var _emp : MutableLiveData<List<Emp>> = MutableLiveData<List<Emp>>()
    val meal : LiveData<List<Emp>> = _emp


    fun addEmp(emp: Emp){
        viewModelScope.launch(Dispatchers.IO) {
            _repo.insertEmp(emp)
        }

    }


}