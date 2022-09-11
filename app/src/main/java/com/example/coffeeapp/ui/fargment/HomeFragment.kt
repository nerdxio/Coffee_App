package com.example.coffeeapp.ui.fargment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeapp.adapters.CoffeeHomeAdapter
import com.example.coffeeapp.databinding.FragmentHomeBinding
import com.example.coffeeapp.entity.CoffeeItem

class HomeFragment : Fragment() {
    lateinit var adapter: CoffeeHomeAdapter
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var list = listOf(
            CoffeeItem("Robusta"),
            CoffeeItem("Americano"),
            CoffeeItem("Espresso"),
            CoffeeItem("Doppio"),
            CoffeeItem("Cortado"),
            CoffeeItem("Galão"),
            CoffeeItem(" Lungo"),

        )
        val layoutManager = GridLayoutManager(context, 2)
        adapter = CoffeeHomeAdapter()
        binding.rvHome.adapter =adapter
        binding.rvHome.layoutManager=layoutManager

        adapter.differ.submitList(list)
    }

}