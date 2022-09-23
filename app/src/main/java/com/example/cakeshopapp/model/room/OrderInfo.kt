package com.example.cakeshopapp.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OrderInfo(

    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val itemCount: Int,
    val totalCount: Int,
    val totalPrice: String,
    val date: String

    )