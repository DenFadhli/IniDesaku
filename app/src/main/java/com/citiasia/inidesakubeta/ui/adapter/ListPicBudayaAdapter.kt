package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.database.PicBudaya
import com.citiasia.inidesakubeta.databinding.ItemCardBudayaBinding

class ListPicBudayaAdapter(private val listPicBudaya: List<PicBudaya>) : RecyclerView.Adapter<ListPicBudayaAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemCardBudayaBinding): RecyclerView.ViewHolder(binding.root) {
        fun binding(pictue: PicBudaya){
            binding.apply {
                Glide.with(itemView)
                    .load(pictue.pic)
                    .into(galeriBudaya)
            }
        }
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: PicBudaya)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemCardBudayaBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup,false )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val picture = listPicBudaya[position]
        holder.binding(picture)
//        holder.itemView.setOnClickListener{
//            onItemClickCallback.onItemClicked(picture)
//        }

    }

    override fun getItemCount(): Int {
        return listPicBudaya.size
    }

}