package com.example.navigationcomponent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationcomponent.databinding.ItemFirstBinding

class CardAdapter(val list : ArrayList<CardModel>, var onClick : (position : Int) -> Unit) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(ItemFirstBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class CardViewHolder(val binding: ItemFirstBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind (cardModel: CardModel){
            binding.imgRick.setImageResource(cardModel.imageView)
            binding.tvName.text = cardModel.name
            binding.tvStatus.text = cardModel.status
            itemView.setOnClickListener {
                onClick(adapterPosition)
            }
        }
    }
}
