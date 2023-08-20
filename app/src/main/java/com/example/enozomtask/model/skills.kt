package com.example.enozomtask.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName="skills")
data class Skills(@PrimaryKey var id:Int, var name :String) :
    Serializable {

}