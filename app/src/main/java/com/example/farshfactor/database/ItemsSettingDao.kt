package com.example.farshfactor.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface ItemsSettingDao {

    @Query("SELECT * FROM itemsSetting")
    fun getAllItems() : Flow<List<ItemsSettings>>

    @Insert
    fun saveSetting(itemsSettings: ItemsSettings)

    @Update
    fun updateSetting(itemsSettings: ItemsSettings)

    @Delete
    fun deleteSetting(itemsSettings: ItemsSettings)
}