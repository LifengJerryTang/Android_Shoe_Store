package com.udacity.shoestore.screens.shoe_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {

    private val _listOfShoes =  MutableLiveData<MutableList<Shoe>>()
    val listOfShoes: LiveData<MutableList<Shoe>>
        get() = _listOfShoes

    init {
        _listOfShoes.value = mutableListOf<Shoe>(
            Shoe("Nike Air Force 1'07", 39.0, "Nike",
                "Durably stitched overlays, clean finishes and the perfect " +
                        "amount of flash to make you shine."),

            Shoe("Jordan Stadium 90", 32.0, "Nike",
                "New classic with an emphasis on comfort, durability and stability."),

            Shoe("Gazelle Shoe", 38.0, "Adidas",
            "Made in leather with completely tonal details," +
                    " the shoes have a clean, iconic look."),

            Shoe("NMD 360 Shoe for kids", 14.0, "Adidas",
                    "Made with a series of recycled materials, " +
                            "this upper features at least 50% recycled content.")
        )
    }
}