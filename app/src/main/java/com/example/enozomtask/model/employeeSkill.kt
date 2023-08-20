package com.example.enozomtask.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName="empSkills")
data class EmpSkills(@PrimaryKey var id:Int, var empId :Int,var skillId: Int) :
    Serializable {

}