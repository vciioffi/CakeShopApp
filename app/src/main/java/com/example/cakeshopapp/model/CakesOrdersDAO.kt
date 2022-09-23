package com.example.cakeshopapp.model

import androidx.room.*
import com.example.cakeshopapp.model.room.Cakes
import com.example.cakeshopapp.model.room.OrderInfo

@Dao
interface CakesOrdersDAO {

    @Query("SELECT * FROM Cakes")
    suspend fun getAllCakes():List<Cakes>

    @Query("SELECT * FROM OrderInfo")
    suspend fun getAllOrders():List<OrderInfo>

    @Query("SELECT * FROM Cakes WHERE id = :id")
    suspend fun getCakesById(id:Int):List<Cakes>

    @Update
    suspend fun update(cake: Cakes)

    @Insert
    suspend fun insert(cake: Cakes)

    @Insert
    suspend fun insertOrder(order: OrderInfo)

    @Delete
    suspend fun delete(cake: Cakes)
}