package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.database.Berita
import com.citiasia.inidesakubeta.databinding.ItemListBeritaBinding

class ListBeritaAdapter(private val listBerita: List<Berita>) : RecyclerView.Adapter<ListBeritaAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemListBeritaBinding): RecyclerView.ViewHolder(binding.root) {
        fun binding(berita: Berita){
            binding.apply {
                Glide.with(itemView)
                    .load(berita.image)
                    .into(gambarBerita)
                judulCardBerita.text = berita.title
                adminDesa.text = berita.admin
                tglBerita.text = berita.time
                pelihatBerita.text = berita.viewer
            }
        }
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Berita)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemListBeritaBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup,false )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val berita = listBerita[position]
        holder.binding(berita)
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(berita)
        }

    }

    override fun getItemCount(): Int {
        return listBerita.size
    }

}