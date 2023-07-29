package com.example.farshfactor.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name="phone")
    val phone:String,
    @ColumnInfo(name="name")
    val name:String,
    @ColumnInfo(name = "orders")
    val order_count:Int = 0
)
