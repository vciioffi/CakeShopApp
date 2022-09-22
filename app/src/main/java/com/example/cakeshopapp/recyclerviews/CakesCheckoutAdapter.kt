package com.example.cakeshopapp.recyclerviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cakeshopapp.R
import com.example.cakeshopapp.databinding.CheckoutItemBinding
import com.example.cakeshopapp.databinding.GridItemCakesBinding

class CakesCheckoutAdapter(val cakes : List<CakesRV>): RecyclerView.Adapter<CakesCheckoutAdapter.CakesCheckoutAdapterViewHolder>() {

    inner class CakesCheckoutAdapterViewHolder(view:View): RecyclerView.ViewHolder(view){
        private val binding = CheckoutItemBinding.bind(view)

        fun bind(cake:CakesRV) {
            binding.tvNameCake.text = cake.name
            binding.tvPriceCake.text = cake.price
            binding.tvCountCake.text = cake.count
            binding.tvTotalCake.text = (((cake.price.toDouble())*(cake.count.toInt())).toString())

        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CakesCheckoutAdapter.CakesCheckoutAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CakesCheckoutAdapterViewHolder(layoutInflater.inflate(R.layout.checkout_item, parent, false))
    }

    override fun onBindViewHolder(holder: CakesCheckoutAdapter.CakesCheckoutAdapterViewHolder, position: Int) {
        val cake: CakesRV = cakes[position]
        holder.bind(cake)
    }

    override fun getItemCount(): Int {
        return cakes.size
    }
}