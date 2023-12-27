package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.remote.model.ResponseKegiatanDesa
import com.citiasia.inidesakubeta.databinding.ItemListContentKegiatanBinding

class KegiatanDesaAdapter(private val kegiatanDesaList: List<ResponseKegiatanDesa>): RecyclerView.Adapter<KegiatanDesaAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ResponseKegiatanDesa)
    }
    class ViewHolder(var binding: ItemListContentKegiatanBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binding(kegiatan: ResponseKegiatanDesa){
            binding.tvNamaKegiatan.text = kegiatan.title
            binding.tvTime.text = kegiatan.time
            binding.tvPlace.text = kegiatan.place
            Glide.with(itemView)
                .load(kegiatan.imageCover)
                .into(binding.ivCover)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListContentKegiatanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return kegiatanDesaList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(kegiatanDesaList[position])
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(kegiatanDesaList[holder.adapterPosition]) }
    }
}