package com.example.cakeshopapp.model.room

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

data class OrderWithCakes(

    @Embedded val orders: Orders,
    @Relation(
        parentColumn = "id",
        entityColumn = "orderId",
        entity = OrderCakes::class,
    )
    val cakes: List<Cakes>

)
@Entity(
    primaryKeys = ["orderId", "cakeId"]
)
data class OrderCakes(
    val orderId: Int,
    val cakeId: Int
)