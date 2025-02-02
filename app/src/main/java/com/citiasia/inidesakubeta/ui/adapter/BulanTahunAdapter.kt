package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.citiasia.inidesakubeta.databinding.ItemListBulanBinding

class BulanTahunAdapter(private val list: Array<String>) : RecyclerView.Adapter<BulanTahunAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    inner class ViewHolder(val view: ItemListBulanBinding) : RecyclerView.ViewHolder(view.root) {
        private val binding = view
        fun bind(data: String) {
            binding.apply {
//                tvNominal.text = data.nominal
//                tvMasaAktif.text = "+ Masa aktif ${data.tambahanHari} hari"
//                tvHarga.text = "Harga Rp. ${data.harga}"
                tvBulan.text = data
                tvTahun.text = "2023"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListBulanBinding.inflate(
                LayoutInflater.from(
                    parent.context),
                parent,
                false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(list[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: String)
    }


}