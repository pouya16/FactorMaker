package com.example.farshfactor.database

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class FactorDetail (
    @PrimaryKey(autoGenerate = true)
    private var id : Int =0,
    @ColumnInfo(name = "factor")
    private var factor_id : Int,
    @ColumnInfo(name = "type")
    private var washing_type: Int,
    @ColumnInfo(name = "price")
    private var price:String,
    @ColumnInfo(name = "meter")
    private var meter:Int
)