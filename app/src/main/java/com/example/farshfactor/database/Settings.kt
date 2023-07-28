package com.example.farshfactor.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Settings(
    @PrimaryKey(autoGenerate = true)
    val id : Int =0,
    @ColumnInfo("type")
    val type:String,
    @ColumnInfo("kind")
    val count_kind:String,
    @ColumnInfo("price")
    val price:String
)
