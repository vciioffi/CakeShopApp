package com.example.cakeshopapp.model

import androidx.room.*

@Dao
interface CakesOrdersDAO {

    @Query("SELECT * FROM Cakes")
    suspend fun getAllCakes():List<Cakes>

    @Query("SELECT * FROM Cakes WHERE id = :id")
    suspend fun getCakesById(id:Int):List<Cakes>

    @Update
    suspend fun update(cake:Cakes)

    @Insert
    suspend fun insert(cake: Cakes)

    @Delete
    suspend fun delete(cake: Cakes)
}