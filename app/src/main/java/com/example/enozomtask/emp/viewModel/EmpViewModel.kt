package com.example.enozomtask.emp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.enozomtask.model.Emp
import com.example.enozomtask.model.RepoInterface
import com.example.enozomtask.model.Skills
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class EmpViewModel (private val _repo : RepoInterface): ViewModel() {
    private var _skill : MutableLiveData<List<Skills>> = MutableLiveData<List<Skills>>()
    val skill : LiveData<List<Skills>> = _skill


    fun addSkill(skill: Skills){
        viewModelScope.launch(Dispatchers.IO) {
            _repo.insertSkill(skill)
        }

    }


}