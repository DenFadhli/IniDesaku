package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.remote.model.ResponseProdukUnggulan
import com.citiasia.inidesakubeta.databinding.ItemListContentProdukUnggulanBinding

class ProdukUnggulanAdapter(private val produkUnggulanList: List<ResponseProdukUnggulan>) : RecyclerView.Adapter<ProdukUnggulanAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: ResponseProdukUnggulan)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    class ViewHolder(var binding: ItemListContentProdukUnggulanBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binding(produk: ResponseProdukUnggulan){
            binding.tvNamaProduk.text = produk.title
            binding.tvView.text = produk.view.toString()
            binding.tvAdmin.text = produk.admin
            binding.tvTime.text = produk.time
            Glide.with(itemView)
                .load(produk.imageCover)
                .into(binding.ivImageCover)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListContentProdukUnggulanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return produkUnggulanList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produk = produkUnggulanList[position]
        holder.binding(produk)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(produk)
        }
    }
}