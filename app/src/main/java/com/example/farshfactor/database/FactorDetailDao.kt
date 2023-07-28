package com.example.farshfactor.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface FactorDetailDao {

    @Query("SELECT * FROM factorDetail WHERE factor= :id")
    fun getDetailsByFactor(id: Int) : Flow<List<FactorDetail>>

    @Insert
    fun saveFactorDetail(factorDetail: FactorDetail)

    @Update
    fun updateFactorDetail(factorDetail: FactorDetail)

    @Delete
    fun deleteFactorDetail(factorDetail: FactorDetail)
}