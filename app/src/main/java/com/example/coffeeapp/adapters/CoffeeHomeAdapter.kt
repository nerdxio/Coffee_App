package com.example.coffeeapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeapp.databinding.CoustemItemBinding
import com.example.coffeeapp.models.coffee.CoffeeItem

class CoffeeHomeAdapter : RecyclerView.Adapter<CoffeeHomeAdapter.CoffeeItemViewHolder>() {

    inner class CoffeeItemViewHolder(private val binding: CoustemItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CoffeeItem) {

            itemView.setOnClickListener {
                binding.tvCoffeeName.text=item.name
                onItemClickListener?.also {
                    it(item)
                }
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<CoffeeItem>() {
        override fun areItemsTheSame(oldItem: CoffeeItem, newItem: CoffeeItem): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: CoffeeItem, newItem: CoffeeItem): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeItemViewHolder {
        val itemBinding =
            CoustemItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoffeeItemViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CoffeeItemViewHolder, position: Int) {
        val item: CoffeeItem = differ.currentList[position]
        holder.bind(item)
    }

    override fun getItemCount() = differ.currentList.size

    //setOnClickListener
    private var onItemClickListener: ((CoffeeItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (CoffeeItem) -> Unit) {
        onItemClickListener = listener
    }
}