package com.example.enozomtask.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName="emp")
data class Emp(@PrimaryKey var name:String, var email :String, var image : String) :
    Serializable {

}