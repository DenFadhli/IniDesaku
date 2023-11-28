package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.citiasia.inidesakubeta.databinding.ItemListPulsaBinding
import com.citiasia.inidesakubeta.data.remote.model.PriceListDummy

class PulsaListAdapter(private val list: List<PriceListDummy>) : RecyclerView.Adapter<PulsaListAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    inner class ViewHolder(val view: ItemListPulsaBinding) : RecyclerView.ViewHolder(view.root) {
        private val binding = view
        fun bind(data: PriceListDummy) {
            binding.apply {
                tvNominal.text = data.nominal
                tvMasaAktif.text = "+ Masa aktif ${data.tambahanHari} hari"
                tvHarga.text = "Harga Rp. ${data.harga}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListPulsaBinding.inflate(
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
        fun onItemClicked(data: PriceListDummy)
    }


}