package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.remote.model.ResponsePelatihan
import com.citiasia.inidesakubeta.databinding.ItemListContentKegiatanBinding

class PelatihanAdapter(private val pelatihanList: List<ResponsePelatihan>): RecyclerView.Adapter<PelatihanAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: ResponsePelatihan)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
    class ViewHolder(var binding: ItemListContentKegiatanBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binding(pelatihan: ResponsePelatihan){
            binding.tvNamaKegiatan.text = pelatihan.title
            binding.tvTime.text = pelatihan.time
            binding.tvPlace.text = pelatihan.place
            Glide.with(itemView)
                .load(pelatihan.imageCover)
                .into(binding.ivCover)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PelatihanAdapter.ViewHolder {
        val binding = ItemListContentKegiatanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pelatihanList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelatihan = pelatihanList[position]
        holder.binding(pelatihan)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(pelatihan)
        }
    }
}