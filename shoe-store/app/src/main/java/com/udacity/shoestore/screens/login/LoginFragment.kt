package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
class LoginFragment: Fragment() {

    private lateinit var binding: FragmentLoginBinding

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

        return binding.root
    }

    private fun onLogin(view: View) {
        val loginValid = validateLoginInfo()

        if (loginValid) {
            view.findNavController()
                .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
    }

    private fun validateLoginInfo(): Boolean {

        val email: String = binding.email.text.toString()
        val password: String = binding.password.text.toString()

        if (email.isBlank() || password.isEmpty()) {
            return false
        }

        return true
    }
}