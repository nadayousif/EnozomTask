package com.example.enozomtask.database

import androidx.room.*
import com.example.enozomtask.model.Emp
import com.example.enozomtask.model.Skills
import kotlinx.coroutines.flow.Flow




@Dao
interface SkillDao {
    @Query("Select * From skills")
    fun getAll(): Flow<List<Skills>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSkill(skill: Skills)

}