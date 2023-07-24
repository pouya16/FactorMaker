package com.example.farshfactor.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Factor(
    @PrimaryKey(autoGenerate = true)
    private var id : Int = 100000,
    @ColumnInfo(name="user")
    private var user_id: Int,
    @ColumnInfo(name="date")
    private var date:String,
    @ColumnInfo(name = "discount")
    private var discount_percentage: Int
)
