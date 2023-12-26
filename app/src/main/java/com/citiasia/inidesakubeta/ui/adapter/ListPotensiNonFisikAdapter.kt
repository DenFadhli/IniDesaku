package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.database.PotensiNonFisik
import com.citiasia.inidesakubeta.databinding.ItemListPotensiNonfisikBinding

class ListPotensiNonFisikAdapter(private val listPotensi: List<PotensiNonFisik>) : RecyclerView.Adapter<ListPotensiNonFisikAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemListPotensiNonfisikBinding): RecyclerView.ViewHolder(binding.root) {
        fun binding(potensi: PotensiNonFisik){
            binding.apply {
                namaPotensiNonfisik.text = potensi.title
                valuePotensi.text = potensi.value
                tahunPotensi.text = potensi.year
            }
        }
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: PotensiNonFisik)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemListPotensiNonfisikBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup,false )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val budaya = listPotensi[position]
        holder.binding(budaya)
//        holder.itemView.setOnClickListener{
//            onItemClickCallback.onItemClicked(budaya)
//        }

    }

    override fun getItemCount(): Int {
        return listPotensi.size
    }

}