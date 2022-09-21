package com.example.cakeshopapp.viewmodel

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import com.example.cakeshopapp.model.CakeShopDb
import com.example.cakeshopapp.model.Cakes
import kotlinx.coroutines.launch


class OrdersViewModel(application: Application): ViewModel() {

    private val _totalPrice = MutableLiveData<Double>()
    val price: LiveData<Double> = _totalPrice

    private val _cakesList = MutableLiveData<MutableList<Cakes>>()
    val cakesList: LiveData<MutableList<Cakes>> = _cakesList


    init {

         val room = CakeShopDb.getDatabase(application).cakeOrdersDAO()

        viewModelScope.launch{

            _cakesList.value = room.getAllCakes().toMutableList()
        }
    }
}