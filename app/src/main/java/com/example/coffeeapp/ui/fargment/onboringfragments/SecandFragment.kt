package com.example.coffeeapp.ui.fargment.onboringfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.example.coffeeapp.R

class SecandFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_secand, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        val next = view.findViewById<ImageView>(R.id.next)
        next.setOnClickListener {
            viewPager?.currentItem = 2
        }
        return view
    }
}