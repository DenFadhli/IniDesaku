package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.database.Budaya
import com.citiasia.inidesakubeta.data.database.Wisata
import com.citiasia.inidesakubeta.databinding.ItemListBigBudayaBinding
import com.citiasia.inidesakubeta.databinding.ItemListBigWisataBinding

class BigListBudayaAdapter(private val listBudaya: List<Budaya>) : RecyclerView.Adapter<BigListBudayaAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemListBigBudayaBinding): RecyclerView.ViewHolder(binding.root) {
        fun binding(budaya: Budaya){
            binding.apply {
                Glide.with(itemView)
                    .load(budaya.image)
                    .into(gambarBudaya)
                judulCardBudaya.text = budaya.title
                adminDesa.text = budaya.admin
                tglBudaya.text = budaya.time
                pelihatBudaya.text = budaya.viewer
            }
        }
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Budaya)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemListBigBudayaBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup,false )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val budaya = listBudaya[position]
        holder.binding(budaya)
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(budaya)
        }

    }

    override fun getItemCount(): Int {
        return listBudaya.size
    }

}