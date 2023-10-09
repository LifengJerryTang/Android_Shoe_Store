package com.udacity.shoestore.screens.shoe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoelistBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.welcome.WelcomeFragmentDirections

class ShoeListFragment: Fragment() {

    private lateinit var binding: FragmentShoelistBinding

    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoelist,
            container,
            false
        )

        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this)[ShoeListViewModel::class.java]

        viewModel.listOfShoes.observe(viewLifecycleOwner
        ) { listOfShoes ->
            populateShoeList(listOfShoes)
        }

        binding.addShoeButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        return binding.root
    }

    private fun populateShoeList(listOfShoes: MutableList<Shoe>) {

    }
}