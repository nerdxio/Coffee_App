package com.example.coffeeapp.ui.fargment.onboringfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.coffeeapp.R
import com.example.coffeeapp.databinding.FragmentFirstBinding
import com.example.coffeeapp.databinding.FragmentHomeBinding


class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)

//        val viewPager = activity?.findViewById<ViewPager>(R.id.viewPager)
//
//        binding.next.setOnClickListener {
//         viewPager?.currentItem =1
//        }
        return binding.root
    }

}