package com.example.enozomtask.model

import kotlinx.coroutines.flow.Flow


interface RepoInterface {
    suspend fun insertEmp(emp: Emp)
    suspend fun deleteEmp(emp: Emp)
    fun getStoredEmp(): Flow<List<Emp>>
    suspend fun insertSkill(skill: Skills)
    fun getStoredSkill(): Flow<List<Skills>>
}