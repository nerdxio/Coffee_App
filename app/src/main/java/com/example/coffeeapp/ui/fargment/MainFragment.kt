package com.example.coffeeapp.ui.fargment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.coffeeapp.R
import com.example.coffeeapp.data.local.CoffeeDatabase
import com.example.coffeeapp.databinding.FragmentMainBinding
import com.example.coffeeapp.repository.DatabaseRepo
import com.example.coffeeapp.ui.viewmodel.DetailsViewModel
import com.example.coffeeapp.ui.viewmodel.DetailsViewModelProviderFactory
import com.example.coffeeapp.utils.Constants
import com.example.coffeeapp.utils.Constants.Companion.TOTAL

class MainFragment : Fragment() {
    val args: MainFragmentArgs by navArgs()
    lateinit var viewModel: DetailsViewModel
    lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val coffee = args.coffee

        binding.apply {
            Glide.with(this@MainFragment).load(coffee.image).into(ivCoffeePic)
            tvCoffeePrice.text = coffee.price.toString()
            cafeName.text=coffee.name
        }
        val db = CoffeeDatabase.invoke(requireActivity())
        val repository = DatabaseRepo(db)
        val viewModelFactory = DetailsViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailsViewModel::class.java)

        var count = 1

        binding.btnUp.setOnClickListener {
            count += 1
            binding.totalCups.text = count.toString()
        }
        binding.btnDown.setOnClickListener {
            if (count > 1) {
                count -= 1
            }
            binding.totalCups.text = count.toString()

        }
        binding.btnAddToCart.setOnClickListener {
            viewModel.insert(coffee)
            TOTAL += (coffee.price?.toInt()?.times(2) ?: 0)
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_homeFragment)
        }
    }


}