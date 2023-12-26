package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.database.Budaya
import com.citiasia.inidesakubeta.data.database.PotensiFisik
import com.citiasia.inidesakubeta.databinding.ItemListBigBudayaBinding
import com.citiasia.inidesakubeta.databinding.ItemListPotensiFisikBinding

class BigListPotensiFisikAdapter(private val listPotensi: List<PotensiFisik>) : RecyclerView.Adapter<BigListPotensiFisikAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemListPotensiFisikBinding): RecyclerView.ViewHolder(binding.root) {
        fun binding(potensi: PotensiFisik){
            binding.apply {
                Glide.with(itemView)
                    .load(potensi.image)
                    .into(gambarPotensi)
                judulCardPotensi.text = potensi.title
                adminDesa.text = potensi.admin
                tglPotensi.text = potensi.time
                pelihatPotensi.text = potensi.viewer
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
        val binding = ItemListPotensiFisikBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup,false )
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