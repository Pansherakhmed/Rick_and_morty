package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.navigationcomponent.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding : FragmentFirstBinding
    private lateinit var adapter: CardAdapter
    private val list = arrayListOf<CardModel>(
        CardModel(R.drawable.ic_morty,"Alive", "Morty Smith"),
        CardModel(R.drawable.ic_albert,"Dead", "Albert Einstein"),
        CardModel(R.drawable.ic_jerry,"Alive", "Jerry Smith"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CardAdapter(list,this::onClick)
        binding.rvCard.adapter = adapter
    }
    private fun onClick(position : Int){
        findNavController().navigate(R.id.secondFragment,  bundleOf("key" to list [position] ))
    }
//    fun loadData(){
//        list.add(CardModel(R.drawable.ic_rick,"Alive", "Rick Sanchez")
//    }



}