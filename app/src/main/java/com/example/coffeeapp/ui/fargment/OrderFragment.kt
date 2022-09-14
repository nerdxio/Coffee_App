package com.example.coffeeapp.ui.fargment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coffeeapp.R
import com.example.coffeeapp.adapters.CoffeeHomeAdapter
import com.example.coffeeapp.adapters.OrderAdapter
import com.example.coffeeapp.data.local.CoffeeDatabase
import com.example.coffeeapp.databinding.FragmentOrderBinding
import com.example.coffeeapp.repository.DatabaseRepo
import com.example.coffeeapp.ui.viewmodel.DetailsViewModel
import com.example.coffeeapp.ui.viewmodel.DetailsViewModelProviderFactory
import com.example.coffeeapp.ui.viewmodel.OrderViewModel
import com.example.coffeeapp.ui.viewmodel.OrderViewModelProviderFactory

class OrderFragment : Fragment() {

    lateinit var binding: FragmentOrderBinding
    private lateinit var adapter: OrderAdapter
    lateinit var viewModel: OrderViewModel
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
    }
}