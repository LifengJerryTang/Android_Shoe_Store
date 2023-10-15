package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.User

class LoginFragment: Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val user: User = User("", "")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        binding.loginButton.setOnClickListener {view: View ->
            onLogin(view)
        }

        binding.user = user

        (activity as AppCompatActivity).supportActionBar?.title = "Login"

        return binding.root
    }

    private fun onLogin(view: View) {
        val loginValid = validateLoginInfo()

        if (loginValid) {
            view.findNavController()
                .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        } else {
            Toast.makeText(context, "Please check your information!", Toast.LENGTH_LONG).show()
        }
    }

    private fun validateLoginInfo(): Boolean {

        user.email = binding.email.text.toString()
        user.password = binding.email.text.toString()

        if (user.email.isBlank() || user.password.isEmpty()) {
            return false
        }

        return true
    }
}