package com.example.coffeeapp.ui.fargment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.coffeeapp.R
import com.example.coffeeapp.databinding.FragmentLoginBinding
import com.example.coffeeapp.models.user.UserLoginRequst
import com.example.coffeeapp.ui.viewmodel.SingInViewModel

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    private val viewModel: SingInViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.loginLiveData.observe(viewLifecycleOwner) {
            it.access_token?.let { it1 -> storeToken(it1) }

            if (it.access_token != null) {
                //store token

                findNavController().navigate(R.id.action_loginFragment2_to_homeActivity2)
            } else {
                Toast.makeText(requireContext(), "error ", Toast.LENGTH_LONG).show()
            }
        }


        binding.btnLoin.setOnClickListener {
            val email = binding.tvEmail.text.toString()
            val password = binding.tvPassword.text.toString()
            viewModel.login(email, password)
        }

        binding.tvSingUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment2_to_signUpFragment)
        }


    }

    fun storeToken(token: String) {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("token", token)
        editor.apply()
    }

}