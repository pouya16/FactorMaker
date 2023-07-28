package com.example.farshfactor.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Addresses::class,Factor::class,FactorDetail::class,Settings::class,User::class],
version = 1, exportSchema = false)
abstract class FactorRoomDatabase:RoomDatabase() {
    abstract fun addressesDao():AddressesDao
    abstract fun factorDao():FactorDao
    abstract fun factorDetailDao():FactorDetailDao
    abstract fun itemSettingsDao():ItemsSettingDao
    abstract fun userDao():UserDao

    companion object{
        @Volatile

        private var INSTANCE: FactorRoomDatabase? = null

        fun getDatabase(context: Context): FactorRoomDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FactorRoomDatabase::class.java,
                    "factor_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}