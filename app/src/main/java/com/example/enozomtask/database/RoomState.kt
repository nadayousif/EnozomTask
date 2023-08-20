package com.example.enozomtask.database

import com.example.enozomtask.model.Emp


sealed class RoomState{
    class Success (val data: List<Emp>): RoomState()
    class Failure(val msg:Throwable): RoomState()
    object Loading: RoomState()
}