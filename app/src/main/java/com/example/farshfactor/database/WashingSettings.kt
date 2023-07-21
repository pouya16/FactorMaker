package com.example.farshfactor.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WashingSettings(
    @PrimaryKey(autoGenerate = true)
    private var id : Int = 0,
    @ColumnInfo("type")
    private var type:String,
    @ColumnInfo("price")
    private var price:String
)
