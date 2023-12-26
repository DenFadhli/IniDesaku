package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.database.Budaya
import com.citiasia.inidesakubeta.data.database.PotensiFisik
import com.citiasia.inidesakubeta.databinding.ItemListSmallBudayaBinding
import com.citiasia.inidesakubeta.databinding.ItemListSmallPotensiBinding

class SmallListPotensiFisikAdapter(private val listPotensi: List<PotensiFisik>) : RecyclerView.Adapter<SmallListPotensiFisikAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemListSmallPotensiBinding): RecyclerView.ViewHolder(binding.root) {
        fun binding(potensi: PotensiFisik){
            binding.apply {
                Glide.with(itemView)
                    .load(potensi.image)
                    .into(gambarPotensi)
                namaPotensi.text = potensi.title
            }
        }
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: PotensiFisik)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemListSmallPotensiBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup,false )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val potensi = listPotensi[position]
        holder.binding(potensi)
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(potensi)
        }

    }

    override fun getItemCount(): Int {
        return listPotensi.size
    }

}