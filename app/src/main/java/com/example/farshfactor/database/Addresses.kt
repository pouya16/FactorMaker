package com.example.farshfactor.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Addresses(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo(name = "userId")
    val user_id: Int,
    @ColumnInfo(name = "lat")
    val lat: Float,
    @ColumnInfo(name = "long")
    val long : Float,
    @ColumnInfo(name = "address")
    val address : String
)
