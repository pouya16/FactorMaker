package com.example.farshfactor.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface AddressesDao {

    @Query("SELECT * FROM addresses WHERE userId = :id")
    fun getAddressesByUser(id:Int): Flow<List<Addresses>>

    @Insert
    fun saveAddress(addresses: Addresses)

    @Update
    fun updateAddress(addresses: Addresses)

    @Delete
    fun deleteAddress(addresses: Addresses)

}