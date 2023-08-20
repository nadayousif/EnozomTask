package com.example.enozomtask.database

import com.example.enozomtask.model.Emp
import com.example.enozomtask.model.Skills
import kotlinx.coroutines.flow.Flow


interface LocalSource {

    suspend fun insertEmp(emp: Emp)
    suspend fun deleteEmp(emp: Emp)
    fun getStoredEmp(): Flow<List<Emp>>

    suspend fun insertSkill(skill: Skills)
    fun getStoredSkills(): Flow<List<Skills>>

}