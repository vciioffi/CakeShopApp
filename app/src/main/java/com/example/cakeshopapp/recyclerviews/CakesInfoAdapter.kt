package com.example.cakeshopapp.recyclerviews

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cakeshopapp.R
import com.example.cakeshopapp.databinding.CakesinfoItemBinding
import com.example.cakeshopapp.databinding.GridItemCakesBinding
import com.example.cakeshopapp.model.room.Cakes

class CakesInfoAdapter(val cakes: List<Cakes>,val context: Context): RecyclerView.Adapter<CakesInfoAdapter.CakesInfoViewHolder>() {

    inner class CakesInfoViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = CakesinfoItemBinding.bind(view)
        fun bind(cakes: Cakes){
            binding.textViewName.text = cakes.name
            binding.textViewDescription.text = cakes.description

            var strPhoto: String = cakes.name.lowercase()
            strPhoto = strPhoto.replace(" ","")
            val res: Resources = Resources.getSystem()

            //id of the image
            val resID = context.resources.getIdentifier(strPhoto, "drawable", context.packageName).toString()



            binding.imgItem.setImageResource(resID.toInt())


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakesInfoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CakesInfoViewHolder(layoutInflater.inflate(R.layout.cakesinfo_item, parent, false))

    }

    override fun onBindViewHolder(holder: CakesInfoViewHolder, position: Int) {
        val cake: Cakes = cakes[position]
        holder.bind(cake)
    }

    override fun getItemCount(): Int {
        return cakes.size
    }
}