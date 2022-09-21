package com.example.cakeshopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.cakeshopapp.model.CakeShopDb
import com.example.cakeshopapp.model.Cakes
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val room = Room.databaseBuilder(this,CakeShopDb::class.java,"Cakes-Orders").build()

       // val room = CakeShopDb.getDatabase(this).cakeOrdersDAO()


        // as we have already inserted all the data into the database, we dont need this snippet anymore
/* lifecycleScope.launch{

     room.sert(Cakes(null,"Carrot Cake","3.15"))
     room.insert(Cakes(null,"Cheese Cake","5.00"))
     room.insert(Cakes(null,"Chocolate Cake","2.50"))
     room.insert(Cakes(null,"Oreo","5.15"))
     room.insert(Cakes(null,"Strawberry Cake","3.15"))
     room.insert(Cakes(null,"Red Velvet","6.00"))
     room.insert(Cakes(null,"Special Cupcake","2.00"))

 }*/

}
}