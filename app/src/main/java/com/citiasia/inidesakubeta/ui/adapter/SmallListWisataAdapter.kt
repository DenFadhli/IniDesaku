package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.database.Wisata
import com.citiasia.inidesakubeta.databinding.ItemListBigWisataBinding
import com.citiasia.inidesakubeta.databinding.ItemListSmallWisataBinding

class SmallListWisataAdapter(private val listWisata: List<Wisata>) : RecyclerView.Adapter<SmallListWisataAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemListSmallWisataBinding): RecyclerView.ViewHolder(binding.root) {
        fun binding(wisata: Wisata){
            binding.apply {
                Glide.with(itemView)
                    .load(wisata.image)
                    .into(gambarWisata)
                namaWisata.text = wisata.title
            }
        }
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Wisata)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemListSmallWisataBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup,false )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val wisata = listWisata[position]
        holder.binding(wisata)
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(wisata)
        }

    }

    override fun getItemCount(): Int {
        return listWisata.size
    }

}