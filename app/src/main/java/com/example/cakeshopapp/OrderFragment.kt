package com.example.cakeshopapp

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.Room
import com.example.cakeshopapp.databinding.FragmentOrderBinding
import com.example.cakeshopapp.model.CakeShopDb
import com.example.cakeshopapp.model.Cakes
import com.example.cakeshopapp.recyclerviews.CakesAdapter
import com.example.cakeshopapp.recyclerviews.CakesRV
import com.example.cakeshopapp.viewmodel.OrdersViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"




/**
 * A simple [Fragment] subclass.
 * Use the [OrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var listCakes: MutableList<CakesRV>
    private lateinit var adapter: CakesAdapter
    private lateinit var sharedViewModel: OrdersViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentOrderBinding.inflate(inflater)
        listCakes = arrayListOf()
        val sharedViewModel = ViewModelProvider(requireActivity())[OrdersViewModel::class.java]

        val room = CakeShopDb.getDatabase(this.requireActivity().applicationContext).cakeOrdersDAO()

        lifecycleScope.launch{

            val dblistcakes1: List<Cakes> = room.getAllCakes().toMutableList()
            sharedViewModel.updateCakesList(dblistcakes1)
        }

    sharedViewModel.cakesList.observe(viewLifecycleOwner, Observer { it
        println("vm $it")
       val dblistcakes: List<Cakes> = it
        val res: Resources = Resources.getSystem()

        for (i in dblistcakes){

            // i need a string that is equals to the image name
            var strPhoto: String = i.name.lowercase()
            strPhoto = strPhoto.replace(" ","")

            //id of the image
            val resID = resources.getIdentifier(strPhoto, "drawable", context?.packageName).toString()

            listCakes.add(CakesRV(resID,i.name,i.price,"0"))
        }
        adapter = CakesAdapter(listCakes)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.adapter!!.notifyDataSetChanged()

        /*
        I have created a MutableLiveData into the adapter so i can observe when the total price change
         */
        adapter.totalPrice.observe(viewLifecycleOwner, Observer{
            binding.tvTotalprice.text = it.toString()
        })
    })



    binding.recyclerView.layoutManager = GridLayoutManager(this.context,2)

    binding.buttonCheckout.setOnClickListener {
        sharedViewModel.updateCheckoutList(adapter.cakes)
        sharedViewModel.updateTotalPrice(binding.tvTotalprice.text.toString().toDouble())
        findNavController().navigate(R.id.action_orderFragment_to_checkoutFragment)

    }
    return binding.root
}

companion object {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderFragment.
     */
    // TODO: Rename and change types and number of parameters
    @JvmStatic
    fun newInstance(param1: String, param2: String) =
        OrderFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
}
}