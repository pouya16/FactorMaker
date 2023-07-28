package com.example.farshfactor.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface ItemsSettingDao {

    @Query("SELECT * FROM settings")
    fun getAllItems() : Flow<List<Settings>>

    @Query("SELECT * FROM settings WHERE id=:id")
    fun getSetting(id:Int): Flow<Settings>

    @Insert
    suspend fun saveSetting(itemsSettings: Settings)

    @Update
    suspend fun updateSetting(itemsSettings: Settings)

    @Delete
    suspend fun deleteSetting(itemsSettings: Settings)
}