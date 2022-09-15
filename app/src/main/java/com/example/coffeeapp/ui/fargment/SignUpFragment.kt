package com.example.coffeeapp.ui.fargment

import android.app.Dialog
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.coffeeapp.R
import com.example.coffeeapp.databinding.FragmentSignUpBinding
import com.example.coffeeapp.models.user.User
import com.example.coffeeapp.ui.viewmodel.SingUpViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SignUpFragment : Fragment() {
    lateinit var binding: FragmentSignUpBinding
    private val viewModel: SingUpViewModel by viewModels()
    lateinit var dialog: Dialog
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog = Dialog(this.requireContext())
        dialog.setContentView(R.layout.custom_dialog_for_sing_up)
        val inset = InsetDrawable(
            AppCompatResources.getDrawable(
                this.requireContext(),
                R.drawable.custom_dialog_background
            ), 100
        )
        dialog.getWindow()?.setBackgroundDrawable(
            inset
        )
        dialog.getWindow()
            ?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(false) //Optional
        dialog.getWindow()?.getAttributes()?.windowAnimations =
            R.style.DialogAnimation //Setting the animations to dialog

        val Okay: Button = dialog.findViewById(R.id.btn_okay)
        val Cancel: Button = dialog.findViewById(R.id.btn_cancel)

        Cancel.setOnClickListener {
            dialog.dismiss()
        }


        binding.btnSingUp.setOnClickListener {
            val name = binding.tvName.text.toString()
            val email = binding.tvEmail.text.toString()
            val password = binding.tvPassword.text.toString()
            viewModel.register(User(name, email, password))
            dialog.show()
        }
        viewModel.registerLiveData.observe(viewLifecycleOwner) { navigate ->
            if (navigate) {
                Okay.setOnClickListener {
                    dialog.dismiss()
                    findNavController().navigate(R.id.action_signUpFragment_to_loginFragment2)
                }

            }
        }

    }

}