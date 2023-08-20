package com.example.enozomtask.database

import android.content.Context
import androidx.room.*
import com.example.enozomtask.model.Emp


@Database(entities = arrayOf(Emp::class), version = 1 )
abstract class EmpDataBase : RoomDatabase() {
    abstract fun getEmpDao(): EmpDao
    companion object{
        @Volatile
        private var INSTANCE: EmpDataBase? = null
        fun getInstance (ctx: Context): EmpDataBase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    ctx.applicationContext, EmpDataBase::class.java, "emp_database")
                    .build()
                INSTANCE = instance
// return instance
                instance }
        }
    }
}