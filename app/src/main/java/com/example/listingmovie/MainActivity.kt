package com.example.listingmovie

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.listingmovie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View{
        _binding = ActivityMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObserver()

        binding.btnLogin.setOnClickListener {
            val inputUsername = binding.etUsername.text.toString()
            val inputPassword = binding.etPassword.text.toString()

            userViewModel.apply {
                getUsername().observe(viewLifecycleOwner){ userNameRegistered ->
                    getPassword().observe(viewLifecycleOwner){ passwordRegistered ->
                        if (inputUsername == userNameRegistered && inputPassword == passwordRegistered) {
                            Toast.makeText(requireContext(), "Login Success", Toast.LENGTH_SHORT).show()
                            setUserLoggedIn(true)
                            findNavController().navigate(R.id.action_ActivityMain_to_ActivityHomepage)
                        } else {
                            Toast.makeText(requireContext(), "Login Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }

        binding.btnRegisterHere.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }


    }

    private fun setObserver() {
        userViewModel.apply {
            isUserLoggedIn().observe(viewLifecycleOwner) { isLoggedIn ->
                if (isLoggedIn) {
                    findNavController().navigate(R.id.action_loginFragment_to_listFragment)
                    Toast.makeText(requireContext(), "You Already Logged in", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}