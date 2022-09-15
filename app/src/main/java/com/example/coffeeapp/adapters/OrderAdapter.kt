package com.example.coffeeapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coffeeapp.databinding.CoustemItemBinding
import com.example.coffeeapp.databinding.CustemOrderItemBinding
import com.example.coffeeapp.models.coffee.Coffee
import com.example.coffeeapp.utils.Constants
import com.example.coffeeapp.utils.Constants.Companion.COUNT
import com.example.coffeeapp.utils.Constants.Companion.TOTAL

class OrderAdapter : RecyclerView.Adapter<OrderAdapter.CoffeeOrderViewHolder>() {
    var price = 0

    inner class CoffeeOrderViewHolder(private val binding: CustemOrderItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Coffee) {
            binding.tvNameCoffee.text = item.name
            binding.tvOrderPrice.text = item.price.toString()

            itemView.apply {
                setOnClickListener {
                    onItemClickListener?.also {
                        it(item)
                    }
                }
                Glide.with(this).load(item.image).into(binding.ivCoffeeCard)
            }

        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Coffee>() {
        override fun areItemsTheSame(oldItem: Coffee, newItem: Coffee): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Coffee, newItem: Coffee): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeOrderViewHolder {
        val binding =
            CustemOrderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoffeeOrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoffeeOrderViewHolder, position: Int) {
        val item: Coffee = differ.currentList[position]
        holder.bind(item)
    }

    override fun getItemCount() = differ.currentList.size

    private var onItemClickListener: ((Coffee) -> Unit)? = null

    fun setOnItemClickListener(listener: (Coffee) -> Unit) {
        onItemClickListener = listener
    }

}