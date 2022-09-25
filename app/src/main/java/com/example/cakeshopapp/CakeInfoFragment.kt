package com.example.cakeshopapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cakeshopapp.databinding.FragmentCakeInfoBinding
import com.example.cakeshopapp.databinding.FragmentOrderBinding
import com.example.cakeshopapp.model.room.CakeShopDb
import com.example.cakeshopapp.model.room.Cakes
import com.example.cakeshopapp.recyclerviews.CakesAdapter
import com.example.cakeshopapp.recyclerviews.CakesInfoAdapter
import com.example.cakeshopapp.recyclerviews.CakesRV
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CakeInfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CakeInfoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var listCakes: MutableList<Cakes>
    private lateinit var adapter: CakesInfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentCakeInfoBinding.inflate(inflater)
        listCakes = arrayListOf()

        val room = CakeShopDb.getDatabase(this.requireActivity().applicationContext).cakeOrdersDAO()

        lifecycleScope.launch{

            listCakes = room.getAllCakes().toMutableList()

            adapter = CakesInfoAdapter(listCakes, requireContext())
            binding.recyclerViewCakeInfo.adapter = adapter
            binding.recyclerViewCakeInfo.layoutManager = LinearLayoutManager(requireActivity())
            binding.recyclerViewCakeInfo.adapter!!.notifyDataSetChanged()
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
         * @return A new instance of fragment CakeInfoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CakeInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}