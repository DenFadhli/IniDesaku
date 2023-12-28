package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.data.remote.model.ResponseTvcc
import com.citiasia.inidesakubeta.databinding.ItemListTvccSearchBinding

class TvccListSearchAdapter(private val list: List<ResponseTvcc>) : RecyclerView.Adapter<TvccListSearchAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ViewHolder(val view: ItemListTvccSearchBinding) : RecyclerView.ViewHolder(view.root) {
        private val binding = view
        fun bind(data: ResponseTvcc) {
            binding.apply {
                tvTitle.text = "TVCC ${data.title}"
                Glide.with(itemView)
                    .load(data.thumnailGambar)
                    .into(imgTvcc)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            ItemListTvccSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(list[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickCallback {
        fun onItemClicked(data: ResponseTvcc)
    }

}