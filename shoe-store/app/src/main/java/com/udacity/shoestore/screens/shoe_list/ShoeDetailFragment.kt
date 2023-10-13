package com.udacity.shoestore.screens.shoe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoedetailBinding
import com.udacity.shoestore.models.Shoe
import java.lang.Double.parseDouble
import java.lang.Integer.parseInt

class ShoeDetailFragment: Fragment() {

    private lateinit var binding: FragmentShoedetailBinding

    private lateinit var viewModel: ShoeListViewModel
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

        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this)[ShoeListViewModel::class.java]

        binding.saveButton.setOnClickListener {view: View ->
            addShoeItem()
            view.findNavController().navigate(ShoeDetailFragmentDirections
                .actionShoeDetailFragmentToShoeListFragment())
        }

        binding.cancelButton.setOnClickListener {view: View ->
            view.findNavController().navigate(ShoeDetailFragmentDirections
                .actionShoeDetailFragmentToShoeListFragment())
        }

        return binding.root

    }

    private fun addShoeItem() {

        if (binding.shoeName.text.isBlank() || binding.shoeSize.text.isBlank()
            || binding.shoeCompany.text.isBlank() || binding.shoeDescription.text.isBlank()) {
            Toast.makeText(context, "Make sure you enter all shoe info!",
                Toast.LENGTH_LONG).show()
        }

        val newShoeItem: Shoe = Shoe(
            binding.shoeName.text.toString(),
            parseDouble(binding.shoeSize.text.toString()),
            binding.shoeCompany.text.toString(),
            binding.shoeDescription.text.toString()
        )

        viewModel.addShoeItem(newShoeItem)
    }
}