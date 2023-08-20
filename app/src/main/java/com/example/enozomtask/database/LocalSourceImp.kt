package com.example.enozomtask.database

import android.content.Context
import com.example.enozomtask.model.Emp
import com.example.enozomtask.model.Skills
import kotlinx.coroutines.flow.Flow


class LocalSourceImp (context: Context):LocalSource{

    private val mealDao : EmpDao by lazy {
        val db  = EmpDataBase.getInstance(context)
        db.getEmpDao()

    }

    private val skillDao : SkillDao by lazy {
        val db  = SkillDataBase.getInstance(context)
        db.getSkillDao()

    }


    override suspend fun insertEmp(emp: Emp) {
        mealDao?.insertEmp(emp)
    }

    override suspend fun deleteEmp(emp: Emp) {
        mealDao?.deleteEmp(emp)
    }

    override fun getStoredEmp(): Flow<List<Emp>> {
        return mealDao.getAll()
    }

    override suspend fun insertSkill(skill: Skills) {
        skillDao?.insertSkill(skill)
    }
    override fun getStoredSkills(): Flow<List<Skills>> {
        return skillDao.getAll()
    }

}