package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.database.Berita
import com.citiasia.inidesakubeta.data.database.Wisata
import com.citiasia.inidesakubeta.databinding.ItemListBeritaBinding
import com.citiasia.inidesakubeta.databinding.ItemListBigWisataBinding

class BigListWisataAdapter(private val listWisata: List<Wisata>) : RecyclerView.Adapter<BigListWisataAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemListBigWisataBinding): RecyclerView.ViewHolder(binding.root) {
        fun binding(wisata: Wisata){
            binding.apply {
                Glide.with(itemView)
                    .load(wisata.image)
                    .into(gambarWisata)
                judulCardWisata.text = wisata.title
                lokasiWisata.text = wisata.lokasi
                waktuWisata.text = wisata.time
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
        val binding = ItemListBigWisataBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup,false )
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