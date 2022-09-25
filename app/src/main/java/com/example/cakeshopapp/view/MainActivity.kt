package com.example.cakeshopapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cakeshopapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //val room = CakeShopDb.getDatabase(this).cakeOrdersDAO()


        // as we have already inserted all the data into the database, we dont need this snippet anymore
 /*lifecycleScope.launch{

     room.insert(Cakes(null,"Carrot Cake","3.15","Carrot cake is a sweet cake with mashed carrots mixed into the dough. The carrot softens in the cooking process, and the cake usually has a dense, smooth texture. Carrots enhance the flavor, texture, and appearance of the cake."))
     room.insert(Cakes(null,"Cheese Cake","5.00","Cheesecake is a very popular dessert since the 20th century made from ricotta, quark cheese, sugar and sometimes other ingredients, such as: eggs, milk or cream, flour, potato, almonds or fruit."))
     room.insert(Cakes(null,"Chocolate Cake","2.50", "Chocolate cake is an internationally known dessert that became popular at the end of the 19th century and is frequently served at gatherings such as birthday parties and weddings."))
     room.insert(Cakes(null,"Oreo Cake","5.15", "The oreo cake is a delicious cake that instead of flour has crushed Oreo cookies, as a filling for this layer cake we are going to use Oreo buttercream or Oreo buttercream, a cream that is very simple to make but delicious, and so that our oreo cake even more irresistible one of the layers of filling will be dark chocolate ganache."))
     room.insert(Cakes(null,"Strawberry Cake","3.15", "Strawberry cake is a cake that uses strawberry as the main ingredient. Strawberries can be used in the cake batter, on top of the cake, and in the frosting. Strawberry shortcakes are usually served cold."))
     room.insert(Cakes(null,"Red Velvet","6.00","In recent times, red velvet has gained immense popularity; It is not only possible to find it in the form of a cake or cupcake, but it is already present in candles, ice cream and even flavored drinks in large chains that serve coffee."))
     room.insert(Cakes(null,"Special Cupcake","2.00", "Special Cupcake with a secret recipe to get an incredible taste"))
     room.insert(Cakes(null,"Happy Cupcake","2.00", "The new Happy Cupcake is trending and is the favourite from our customers. Do not miss it!"))


 }*/

}
}