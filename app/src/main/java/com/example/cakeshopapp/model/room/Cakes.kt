package com.example.cakeshopapp.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Cakes(
   @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name : String,
    val price: String,
    val description: String

)
