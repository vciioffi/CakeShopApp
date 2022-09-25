# CakeShopApp
Application that uses Room Library and MVVM architecture so the user can order cakes and check information about the orders


## Tools
|      Kotlin       |  Room   |                 MVVM                 |          Navigation Component
|:-------------:|:------:|:--------------------------------------:|:--------------------------------------:|
<img src="images/kotlin.png" width="200px"> | <img src="images/room.png" width="200px">| <img src="images/MVVM.png" width="200px"> | <img src="images/navigationcomponent.png" width="200px">


## Information

With this application the user can order different types of cakes and also ckeck the information about the cakes and the orders. all the data is stored in a local database. 


## Functioning
### Welcome

When the application starts, a welcoming screen appears which shows three button with the different destinations.

<img src="images/Screenshot_1664118456.png" width="200px"> 


### Order Fragment

If the user wants to make an order, a new fragment will appear showing a list with al the cakes availables and their price. The total price of the order will be updated using the viewmodel 

<img src="images/Screenshot_1664118488.png" width="200px"> 


### Checkout Fragment

Once the user has finished the order, a fragment will appear showing all the information of the order so the user can check if everything is okay. if the order is correct, the user can finish the operation, and the order will be saved on the local database

<img src="images/Screenshot_1664118493.png" width="200px"> 

<img src="images/Screenshot_1664118495.png" width="200px"> 


### Order History Fragment

the user can see the order history by accessing the corresponding fragment from the main menu

<img src="images/Screenshot_1664118509.png" width="200px"> 


### Cake Info Fragment

the user can also check for the cakes information to find out more about it

<img src="images/Screenshot_1664118526.png" width="200px"> 



