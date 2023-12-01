package com.citiasia.inidesakubeta.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.remote.model.ResponseTvcc
import com.citiasia.inidesakubeta.databinding.CardTvccLiveBinding
import com.citiasia.inidesakubeta.databinding.ItemListContentTvccBinding

class TvccBannerAdapter(private val list: List<ResponseTvcc>) : RecyclerView.Adapter<TvccBannerAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    inner class ViewHolder(val view: CardTvccLiveBinding) : RecyclerView.ViewHolder(view.root) {
        private val binding = view
        fun bind(data: ResponseTvcc) {
            binding.apply {
                tvTitle.text = "TVCC ${data.title}"
                Glide.with(itemView)
                    .load(data.thumnailGambar)
                    .into(imgMainContent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CardTvccLiveBinding.inflate(
                LayoutInflater.from(parent.context),
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
        fun onItemClicked(data: ResponseTvcc)
    }



}