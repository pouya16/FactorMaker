package com.example.farshfactor

import android.app.Application
import com.example.farshfactor.database.FactorRoomDatabase

class MyApp : Application() {
    val database: FactorRoomDatabase by lazy { FactorRoomDatabase.getDatabase(this) }
}