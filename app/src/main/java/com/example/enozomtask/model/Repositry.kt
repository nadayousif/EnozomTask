package com.example.enozomtask.model

import com.example.enozomtask.database.LocalSource
import kotlinx.coroutines.flow.Flow


class Repositry constructor(var localSource: LocalSource):RepoInterface{

    companion object {
        private var instance : Repositry? = null
        fun getInstance(localSource: LocalSource):Repositry{
            return instance?: synchronized(this){
                val temp = Repositry(localSource)
                instance = temp
                temp
            }
        }
    }

    override suspend fun insertEmp(emp: Emp) {
        localSource.insertEmp(emp)
    }

    override suspend fun deleteEmp(emp: Emp) {
        localSource.deleteEmp(emp)
    }

    override fun getStoredEmp(): Flow<List<Emp>> {
        return localSource.getStoredEmp()
    }

    override suspend fun insertSkill(skill: Skills) {
        localSource.insertSkill(skill)
    }

    override fun getStoredSkill(): Flow<List<Skills>> {
        return localSource.getStoredSkills()
    }



}