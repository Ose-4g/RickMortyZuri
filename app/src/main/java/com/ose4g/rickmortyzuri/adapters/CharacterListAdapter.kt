package com.ose4g.rickmortyzuri.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ose4g.rickmortyzuri.databinding.CharacterListItemBinding
import com.ose4g.rickmortyzuri.models.Result

class CharacterListAdapter(val context: Context):
    PagingDataAdapter<Result,CharacterListAdapter.CharacterViewHolder>(CharacterComparator){

    class CharacterViewHolder(val binding: CharacterListItemBinding):
            RecyclerView.ViewHolder(binding.root)
    {
        fun bind(context: Context, character:Result)
        {
            Glide.with(context)
                .load(character.image!!)
                .into(binding.image)
        }
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(context,getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding:CharacterListItemBinding = CharacterListItemBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return CharacterViewHolder(binding)
    }

    object CharacterComparator:DiffUtil.ItemCallback<Result>()
    {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.names == newItem.names
        }

    }
}