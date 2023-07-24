package com.example.farshfactor.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getUsers(): Flow<List<User>>

    @Query("SELECT * FROM user WHERE name= :name")
    fun  getUserByName(name:String) : Flow<List<User>>

    @Query("SELECT * FROM user WHERE phone= :phone")
    fun getUserByPhone(phone: String) : Flow<List<User>>

    @Query("SELECT * FROM user WHERE id= :id")
    fun getUserById(id:Int): Flow<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user:User)

    @Delete
    suspend fun deleteUser(user: User)


}