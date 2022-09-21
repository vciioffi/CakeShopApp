package com.example.cakeshopapp.recyclerviews

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.cakeshopapp.R
import com.example.cakeshopapp.databinding.GridItemCakesBinding
import kotlin.properties.Delegates

class CakesAdapter(val cakes : List<CakesRV>): RecyclerView.Adapter<CakesAdapter.CakesViewHolder>() {

    private var _totalprice: Double = 0.0
    val totalPrice = MutableLiveData<Double>()

    inner class CakesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = GridItemCakesBinding.bind(view)
        @SuppressLint("SetTextI18n")
        fun bind(cake:CakesRV) {
            binding.nombre.text = cake.name
            binding.precio.text = cake.price
            binding.cantidad.text = cake.count

           // val res: Resources = Resources.getSystem()
            //var drawable: Drawable = res.getDrawable(R.drawable.carrotcake)
            binding.imagen.setImageResource(cake.photo.toInt())
            binding.plusButton.setOnClickListener {

                binding.cantidad.text=(Integer.parseInt(binding.cantidad.text as String)+1).toString()
                _totalprice += (cake.price.toDouble())
                totalPrice.value = _totalprice



            }
            binding.minusButton.setOnClickListener {

                if (binding.cantidad.text.equals("0")){

                }else {
                    binding.cantidad.text =
                        (Integer.parseInt(binding.cantidad.text as String) - 1).toString()
                    _totalprice -=(cake.price.toDouble())
                    totalPrice.value = _totalprice
                }
            }

        }
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakesViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return CakesViewHolder(layoutInflater.inflate(R.layout.grid_item_cakes, parent, false))

        }

        override fun onBindViewHolder(holder: CakesViewHolder, position: Int) {
            val cake: CakesRV = cakes[position]
            holder.bind(cake)
        }

        override fun getItemCount(): Int {
            return cakes.size
        }
    }
