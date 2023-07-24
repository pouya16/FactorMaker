package com.example.farshfactor.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Addresses::class,Factor::class,FactorDetail::class,ItemsSettings::class,User::class],
version = 1, exportSchema = false)
abstract class FactorRoomDatabase:RoomDatabase() {
    abstract fun addressesDao():AddressesDao
    abstract fun factorDao():FactorDao
    abstract fun factorDetailDao():FactorDetailDao
    abstract fun itemSettingsDao():ItemsSettingDao
    abstract fun userDao():UserDao
}