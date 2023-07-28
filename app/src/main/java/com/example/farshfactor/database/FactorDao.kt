package com.example.farshfactor.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface FactorDao {

    @Query("SELECT * FROM factor")
    fun getAllFactors() : Flow<List<Factor>>

    @Query("SELECT * FROM factor WHERE user= :id")
    fun getFactorsByUser(id:Int): Flow<List<Factor>>

    @Query("SELECT * FROM factor WHERE date= :date ")
    fun getFactorByDate(date:String): Flow<List<Factor>>

    @Insert
    fun saveFactor(factor: Factor)

    @Update
    fun updateFactor(factor: Factor)

    @Delete
    fun deleteFactor(factor: Factor)


}