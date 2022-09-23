package com.example.cakeshopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.cakeshopapp.model.room.CakeShopDb
import com.example.cakeshopapp.model.room.Cakes
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //val room = CakeShopDb.getDatabase(this).cakeOrdersDAO()


        // as we have already inserted all the data into the database, we dont need this snippet anymore
 /*lifecycleScope.launch{

     room.insert(Cakes(null,"Carrot Cake","3.15"))
     room.insert(Cakes(null,"Cheese Cake","5.00"))
     room.insert(Cakes(null,"Chocolate Cake","2.50"))
     room.insert(Cakes(null,"Oreo","5.15"))
     room.insert(Cakes(null,"Strawberry Cake","3.15"))
     room.insert(Cakes(null,"Red Velvet","6.00"))
     room.insert(Cakes(null,"Special Cupcake","2.00"))
     room.insert(Cakes(null,"Happy Cupcake","2.00"))


 }*/

}
}