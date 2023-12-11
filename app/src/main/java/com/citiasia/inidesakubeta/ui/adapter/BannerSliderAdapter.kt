package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.databinding.CardBannerPpobBinding

class BannerSliderAdapter(private val list: List<String>) : RecyclerView.Adapter<BannerSliderAdapter.ViewHolder>() {

    inner class ViewHolder(view: CardBannerPpobBinding) : RecyclerView.ViewHolder(view.root) {
        private val binding = view
        fun bind(data: String) {
            binding.apply {
                Glide.with(itemView)
                    .load(data)
                    .into(imgBanner)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CardBannerPpobBinding.inflate(
                LayoutInflater.from(
                    parent.context),
                parent,
                false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }


}