package com.example.coffeeapp.ui.fargment


import android.app.Dialog
import android.graphics.drawable.InsetDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coffeeapp.R
import com.example.coffeeapp.adapters.OrderAdapter
import com.example.coffeeapp.data.local.CoffeeDatabase
import com.example.coffeeapp.databinding.FragmentOrderBinding
import com.example.coffeeapp.repository.DatabaseRepo
import com.example.coffeeapp.ui.viewmodel.OrderViewModel
import com.example.coffeeapp.ui.viewmodel.OrderViewModelProviderFactory
import com.example.coffeeapp.utils.Constants
import com.example.coffeeapp.utils.Constants.Companion.COUNT
import com.example.coffeeapp.utils.Constants.Companion.TOTAL


class OrderFragment : Fragment() {

    lateinit var binding: FragmentOrderBinding
    private lateinit var adapter: OrderAdapter
    lateinit var viewModel: OrderViewModel
    lateinit var dialog: Dialog
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOrderBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = CoffeeDatabase.invoke(requireActivity())
        val repository = DatabaseRepo(db)
        val viewModelFactory = OrderViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(OrderViewModel::class.java)


        val layoutManager = GridLayoutManager(context, 2)
        adapter = OrderAdapter()
        binding.rvOrder.adapter = adapter

        viewModel.getSaveCoffee().observe(viewLifecycleOwner, Observer {
            adapter.differ.submitList(it)
        })



        binding.tvTotalMoney.text = TOTAL.toString()
        //Create the Dialog here
        //Create the Dialog here
        dialog = Dialog(this.requireContext())
        dialog.setContentView(R.layout.custom_dialog_layout)
        val inset = InsetDrawable(
            getDrawable(
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

        //
        binding.btnOrder.setOnClickListener {
            viewModel.deleteAll()
            TOTAL = 0
            COUNT = 1
            dialog.show();
        }

        Okay.setOnClickListener {
            dialog.dismiss();
        }

        Cancel.setOnClickListener {
            dialog.dismiss();
        }
    }
}