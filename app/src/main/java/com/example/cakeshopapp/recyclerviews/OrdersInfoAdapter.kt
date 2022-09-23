package com.example.cakeshopapp.recyclerviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cakeshopapp.R
import com.example.cakeshopapp.databinding.CheckoutItemBinding
import com.example.cakeshopapp.databinding.OrdersItemBinding
import com.example.cakeshopapp.model.room.OrderInfo

class OrdersInfoAdapter(val orders: List<OrderInfo>):RecyclerView.Adapter<OrdersInfoAdapter.OrdersInfoAdapterViewHolder>() {

    inner class OrdersInfoAdapterViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding = OrdersItemBinding.bind(view)

        fun bind(orderInfo: OrderInfo) {

            binding.tvDate.text = orderInfo.date
            binding.tvItemCount.text = orderInfo.itemCount.toString()
            binding.tvTotalCount.text = orderInfo.totalCount.toString()
            binding.tvTotalPrice.text = orderInfo.totalPrice
            binding.tvOrderId.text = "Order Nº ${orderInfo.id}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersInfoAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return OrdersInfoAdapterViewHolder(layoutInflater.inflate(R.layout.orders_item, parent, false))
    }

    override fun onBindViewHolder(holder: OrdersInfoAdapterViewHolder, position: Int) {
        val order: OrderInfo = orders[position]
        holder.bind(order)
    }

    override fun getItemCount(): Int {
        return orders.size
    }
}