package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.model.ResponsePelayananDesa
import com.citiasia.inidesakubeta.databinding.ItemListContentPelayananBinding

class PelayananDesaAdapter(private val pelayananDesaList: List<ResponsePelayananDesa>) : RecyclerView.Adapter<PelayananDesaAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: ResponsePelayananDesa)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
    class ViewHolder(var binding: ItemListContentPelayananBinding) : RecyclerView.ViewHolder(binding.root){
        fun binding(pelayanan: ResponsePelayananDesa){
            binding.tvNamaKegiatan.text = pelayanan.title
            binding.tvTime.text = pelayanan.time
            binding.tvPlace.text = pelayanan.place
            binding.ivCover.setImageResource(R.drawable.icon_pelayanan)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListContentPelayananBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pelayananDesaList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelayanan = pelayananDesaList[position]
        holder.binding(pelayanan)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(pelayanan)
        }
    }
}