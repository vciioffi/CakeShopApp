package com.example.cakeshopapp.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Orders(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name : String,
    val price: String

)
