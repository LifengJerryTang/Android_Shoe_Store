package com.udacity.shoestore.screens.shoe_list

import android.os.Bundle
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

        val shoeName = binding.shoeName.text.toString()
        val shoeSize = binding.shoeSize.text.toString()
        val shoeComp = binding.shoeCompany.text.toString()
        val shoeDesc = binding.shoeDescription.text.toString()


        if (shoeName.isBlank() || shoeSize.isBlank() || shoeComp.isBlank()
            || shoeDesc.isBlank()) {
            Toast.makeText(context, "Make sure you enter all shoe info!",
                Toast.LENGTH_LONG).show()
        }

        val newShoeItem: Shoe = Shoe(
            shoeName, parseDouble(shoeSize), shoeComp, shoeDesc
        )

        viewModel.addShoeItem(newShoeItem)

        Toast.makeText(context, "SUCCESSFULLY added your new $shoeName !",
            Toast.LENGTH_LONG).show()
    }
}