package com.udacity.shoestore.screens.shoe_list

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoedetailBinding
import com.udacity.shoestore.models.Shoe
import java.lang.Double.parseDouble
import java.lang.Integer.parseInt

class ShoeDetailFragment: Fragment() {

    private lateinit var binding: FragmentShoedetailBinding

    private val viewModel: ShoeListViewModel by activityViewModels()

    private val newShoe: Shoe = Shoe("", 0.0, "", "")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoedetail,
            container,
            false
        )

        binding.newShoe = newShoe

        binding.saveButton.setOnClickListener {view: View ->
            addShoeItem()
            view.findNavController().navigate(ShoeDetailFragmentDirections
                .actionShoeDetailFragmentToShoeListFragment())
        }

        binding.cancelButton.setOnClickListener {view: View ->
            view.findNavController().navigate(ShoeDetailFragmentDirections
                .actionShoeDetailFragmentToShoeListFragment())
        }

        (activity as AppCompatActivity).supportActionBar?.title = "Shoe Detail"

        return binding.root

    }

    private fun addShoeItem() {

        if (newShoe.name.isBlank() || newShoe.company.isBlank() || newShoe.description.isBlank()
            || binding.shoeSize.toString().isBlank()) {
            Toast.makeText(context, "Make sure you enter all shoe info!",
                Toast.LENGTH_LONG).show()
        }

        newShoe.size = parseDouble(binding.shoeSize.text.toString())

        viewModel.addShoeItem(newShoe)

        Toast.makeText(context, "SUCCESSFULLY added your new ${newShoe.name} !",
            Toast.LENGTH_LONG).show()
    }
}