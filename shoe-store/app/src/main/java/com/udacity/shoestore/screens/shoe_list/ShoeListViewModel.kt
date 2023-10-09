package com.udacity.shoestore.screens.shoe_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {

    private val _listOfShoes =  MutableLiveData<MutableList<Shoe>>()
    val listOfShoes: LiveData<MutableList<Shoe>>
        get() = _listOfShoes

}