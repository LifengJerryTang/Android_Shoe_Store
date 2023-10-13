package com.udacity.shoestore.screens.shoe_list

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class ShoeListAdapter(private val context: Context, private val listOfShoes: MutableList<Shoe>):
                                ArrayAdapter<Shoe>(context, R.layout.shoe_list_item, listOfShoes) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.shoe_list_item, null);

        val shoeName: TextView = view.findViewById(R.id.shoeName)
        val shoeDescription: TextView = view.findViewById(R.id.shoeDescription)
        val shoeCompany: TextView = view.findViewById(R.id.shoeCompany)
        val shoeSize: TextView = view.findViewById(R.id.shoeSize)

        //TODO: Remember to set image source!!
        val shoeImage: ImageView = view.findViewById(R.id.shoeImage)

        shoeName.text = listOfShoes[position].name
        shoeDescription.text = listOfShoes[position].description
        shoeCompany.text = listOfShoes[position].company
        shoeSize.text = listOfShoes[position].size.toString()

        return view
    }
}