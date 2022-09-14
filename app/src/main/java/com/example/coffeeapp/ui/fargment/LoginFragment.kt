package com.example.coffeeapp.ui.fargment

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.coffeeapp.R
import com.example.coffeeapp.databinding.FragmentLoginBinding
import com.example.coffeeapp.models.user.UserLoginRequst
import com.example.coffeeapp.ui.viewmodel.SingInViewModel

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    private val viewModel: SingInViewModel by viewModels()
    lateinit var dialog: Dialog
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog = Dialog(this.requireContext())
        dialog.setContentView(R.layout.custom_dialog_for_loin)
        dialog.getWindow()?.setBackgroundDrawable(
            AppCompatResources.getDrawable(
                this.requireContext(),
                R.drawable.custom_dialog_background
            )
        )
        dialog.getWindow()
            ?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false) //Optional

        dialog.getWindow()?.getAttributes()?.windowAnimations =
            R.style.DialogAnimation //Setting the animations to dialog

        val Okay: Button = dialog.findViewById(R.id.btn_okay)
        val Cancel: Button = dialog.findViewById(R.id.btn_cancel)

        Okay.setOnClickListener {
            dialog.dismiss();
        }
        Cancel.setOnClickListener {
            dialog.dismiss();
        }


        viewModel.loginLiveData.observe(viewLifecycleOwner) {
            it.access_token?.let { it1 -> storeToken(it1) }

            if (it.access_token != null) {
                //store token

                findNavController().navigate(R.id.action_loginFragment2_to_homeActivity2)
            } else {

                dialog.show();

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