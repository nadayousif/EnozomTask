package com.example.enozomtask.database

import androidx.room.*
import com.example.enozomtask.model.Emp
import kotlinx.coroutines.flow.Flow

@Dao
interface EmpDao {
    @Query("Select * From emp")
    fun getAll(): Flow<List<Emp>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertEmp(emp:Emp)

    @Delete
    suspend fun deleteEmp(emp: Emp): Int

}