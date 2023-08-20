package com.example.enozomtask.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.enozomtask.model.Emp
import com.example.enozomtask.model.Skills


@Database(entities = arrayOf(Skills::class), version = 1 )
abstract class SkillDataBase : RoomDatabase() {
    abstract fun getSkillDao(): SkillDao
    companion object{
        @Volatile
        private var INSTANCE: SkillDataBase? = null
        fun getInstance (ctx: Context): SkillDataBase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    ctx.applicationContext, SkillDataBase::class.java, "skill_database")
                    .build()
                INSTANCE = instance
// return instance
                instance }
        }
    }
}