package com.example.farshfactor.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Factor(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    @ColumnInfo(name="user")
    val user_id: Int,
    @ColumnInfo(name="date")
    val date:String,
    @ColumnInfo(name = "discount")
    val discount_percentage: Int
)
