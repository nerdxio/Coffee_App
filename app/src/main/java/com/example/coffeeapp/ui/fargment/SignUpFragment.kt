package com.example.coffeeapp.ui.fargment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.coffeeapp.R
import com.example.coffeeapp.databinding.FragmentSignUpBinding
import com.example.coffeeapp.models.user.User
import com.example.coffeeapp.ui.viewmodel.SingUpViewModel

class SignUpFragment : Fragment() {
    lateinit var binding: FragmentSignUpBinding
    private val viewModel: SingUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.registerLiveData.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment2)
        }

        binding.floatingActionButton.setOnClickListener {
            val name = binding.tvName.text.toString()
            val email = binding.tvEmail.text.toString()
            val password = binding.tvPassword.text.toString()

            viewModel.register(User(name, email, password))

        }
    }

}