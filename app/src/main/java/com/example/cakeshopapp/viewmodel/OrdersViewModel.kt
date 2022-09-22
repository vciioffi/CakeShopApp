package com.example.cakeshopapp.viewmodel

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import com.example.cakeshopapp.model.CakeShopDb
import com.example.cakeshopapp.model.Cakes
import com.example.cakeshopapp.recyclerviews.CakesRV
import kotlinx.coroutines.launch


class OrdersViewModel(): ViewModel() {

    private val _totalPrice = MutableLiveData<Double>()
    val price: LiveData<Double> = _totalPrice

    private val _cakesList = MutableLiveData<MutableList<Cakes>>()
    val cakesList: LiveData<MutableList<Cakes>> = _cakesList

    private val _cakesListCheckout = MutableLiveData<MutableList<CakesRV>>()
    val cakesListCheckout: LiveData<MutableList<CakesRV>> = _cakesListCheckout


    init {

    /*     val room = CakeShopDb.getDatabase(application).cakeOrdersDAO()

        viewModelScope.launch{

            _cakesList.value = room.getAllCakes().toMutableList()
        }*/
    }
    fun updateCheckoutList(cakes: List<CakesRV>){

        _cakesListCheckout.value = cakes.toMutableList()
    }

    fun updateCakesList(cakes: List<Cakes>){

        _cakesList.value= cakes.toMutableList()
    }
    fun updateTotalPrice(price: Double){

        _totalPrice.value= price
    }

}