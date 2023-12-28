package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.remote.model.ResponsePenyuluhan
import com.citiasia.inidesakubeta.databinding.ItemListContentKegiatanBinding

class PenyuluhanDesaAdapter(private val penyuluhanList: List<ResponsePenyuluhan>): RecyclerView.Adapter<PenyuluhanDesaAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: ResponsePenyuluhan)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
    class ViewHolder(var binding: ItemListContentKegiatanBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binding(penyuluhan: ResponsePenyuluhan){
            binding.tvNamaKegiatan.text = penyuluhan.title
            binding.tvTime.text = penyuluhan.time
            binding.tvPlace.text = penyuluhan.place
            Glide.with(itemView)
                .load(penyuluhan.imageCover)
                .into(binding.ivCover)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListContentKegiatanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return penyuluhanList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val penyuluhan = penyuluhanList[position]
        holder.binding(penyuluhan)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(penyuluhan)
        }
    }
}