package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.remote.model.ResponseTvcc
import com.citiasia.inidesakubeta.databinding.ItemListTvccPreviewBinding

class TvccListPreviewAdapter(private val list: List<ResponseTvcc>) : RecyclerView.Adapter<TvccListPreviewAdapter.ViewHolder>() {

    inner class ViewHolder(val view: ItemListTvccPreviewBinding) : RecyclerView.ViewHolder(view.root) {
        private val binding = view
        fun bind(data: ResponseTvcc) {
            binding.apply {
                tvTitle.text = data.title
                tvMulai.text = "${data.jamMulai}.00 - "
                tvAkhir.text = "${data.jamSelesai}.00"
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            ItemListTvccPreviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}