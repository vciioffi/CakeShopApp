package com.example.cakeshopapp.model.room

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cakeshopapp.model.CakesOrdersDAO

@Database(
    entities = [Cakes::class, Orders::class, OrderCakes::class,OrderInfo::class],
    version = 1

)
abstract class CakeShopDb: RoomDatabase(){

    abstract fun cakeOrdersDAO(): CakesOrdersDAO

    companion object{

        @Volatile
        private var INSTANCE: CakeShopDb? = null

        fun getDatabase(context: Context): CakeShopDb {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CakeShopDb::class.java,
                    "Cakes_Orders"
                ).build()
                INSTANCE =instance
                return instance
            }
        }
    }
}