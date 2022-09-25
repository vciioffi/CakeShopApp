package com.example.cakeshopapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cakeshopapp.databinding.FragmentCheckoutBinding
import com.example.cakeshopapp.model.room.CakeShopDb
import com.example.cakeshopapp.model.room.OrderInfo
import com.example.cakeshopapp.recyclerviews.CakesCheckoutAdapter
import com.example.cakeshopapp.recyclerviews.CakesRV
import com.example.cakeshopapp.viewmodel.OrdersViewModel
import kotlinx.coroutines.launch
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CheckoutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CheckoutFragment : Fragment() {
    override fun onStop() {
        requireActivity().viewModelStore.clear()
        super.onStop()
    }
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var listCakesCheckout: MutableList<CakesRV>
    private lateinit var adapter: CakesCheckoutAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

            // This callback will only be called when MyFragment is at least Started.
            val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
                requireActivity().viewModelStore.clear()
                println("atras")

            }

            callback.isEnabled = true
            // The callback can be enabled or disabled here or in the lambda

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentCheckoutBinding.inflate(inflater)
        val sharedViewModel = ViewModelProvider(requireActivity())[OrdersViewModel::class.java]

        listCakesCheckout = sharedViewModel.cakesListCheckout.value!!

        adapter = CakesCheckoutAdapter(listCakesCheckout)
        binding.recyclerViewCheckout.adapter = adapter
        binding.recyclerViewCheckout.adapter!!.notifyDataSetChanged()
        binding.recyclerViewCheckout.layoutManager = LinearLayoutManager(this.requireActivity().applicationContext)
        binding.buttonPrice.text = sharedViewModel.price.value.toString()


        binding.btnConfirmOrder.setOnClickListener {

            lifecycleScope.launch{

                confirmOrder(sharedViewModel,binding)

            }
        }

        return binding.root
    }

    private suspend fun confirmOrder(sharedViewModel: OrdersViewModel, binding: FragmentCheckoutBinding) {

        val room = CakeShopDb.getDatabase(this.requireActivity().applicationContext).cakeOrdersDAO()

        val listcakeIterat: List<CakesRV> = sharedViewModel.cakesListCheckout.value!!
        var itemCount: Int = 0
        var totalCount: Int =0

        for (i in listcakeIterat){
            if (i.count != "0"){
                itemCount++

            }
            totalCount += (i.count.toInt())
        }

        room.insertOrder(OrderInfo(null,itemCount,totalCount,binding.buttonPrice.text.toString(),Calendar.getInstance().time.toString()))
        Toast.makeText(requireActivity().applicationContext, "Order saved correctly!!", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_checkoutFragment_to_homeFragment)

        requireActivity().viewModelStore.clear();

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CheckoutFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CheckoutFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}