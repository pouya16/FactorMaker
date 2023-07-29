package com.example.farshfactor.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FactorDetail (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    @ColumnInfo(name = "factor")
    val factor_id : Int,
    @ColumnInfo(name = "type")
    val washing_type: Int,
    @ColumnInfo(name = "type_exp")
    val washing_extra: String,
    @ColumnInfo(name = "price")
    val price:String,
    @ColumnInfo(name = "meter")
    val meter:Int
)