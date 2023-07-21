package com.example.farshfactor.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0,
    @ColumnInfo(name="phone")
    private var phone:String,
    @ColumnInfo(name="name")
    private var name:String,
    @ColumnInfo(name = "orders")
    private var order_count:Int
)
