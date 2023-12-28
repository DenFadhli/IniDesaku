package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.remote.dummyObject.Donasi
import com.citiasia.inidesakubeta.data.remote.model.ResponseDonasi
import com.citiasia.inidesakubeta.databinding.ActivityDonasiBinding
import com.citiasia.inidesakubeta.databinding.ItemListContentDonasiBinding

class DonasiAdapter(private val donasiList: List<ResponseDonasi>):
    RecyclerView.Adapter<DonasiAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: ResponseDonasi)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
    class ViewHolder(var binding: ItemListContentDonasiBinding): RecyclerView.ViewHolder(binding.root) {
        fun binding(donasi: ResponseDonasi){
            binding.tvNameDonasi.text = donasi.title
            binding.tvTime.text = donasi.time
            binding.tvUsers.text = donasi.admin
            Glide.with(itemView)
                .load(donasi.imageCover)
                .into(binding.ivCover)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListContentDonasiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return donasiList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val donasi = donasiList[position]
        holder.binding(donasi)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(donasi)
        }
    }
}