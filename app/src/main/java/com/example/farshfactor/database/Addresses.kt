package com.example.farshfactor.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
data class Addresses(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    @ColumnInfo(name = "userId")
    var user_id: Int,
    @ColumnInfo(name = "lat")
    var lat: Float,
    @ColumnInfo(name = "long")
    var long : Float,
    @ColumnInfo(name = "address")
    var address : String
)
