package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.model.PenilaianUserModel

class PenilaianUserAdapter(private val penilaianUserModel: List<PenilaianUserModel>) : RecyclerView.Adapter<PenilaianUserAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_penilaian_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = penilaianUserModel[position]
        Glide.with(holder.itemView.context)
            .load(data.fotoUser)
            .into(holder.fotoUser)
        Glide.with(holder.itemView.context)
            .load(data.ratingUser)
            .into(holder.ratingUser)
        holder.namaUser.text = data.namaUser
        holder.ulasanUser.text = data.ulasanUser
    }

    override fun getItemCount(): Int = penilaianUserModel.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fotoUser: ImageView = itemView.findViewById(R.id.iv_user_avatar_penilaian)
        val ratingUser: ImageView = itemView.findViewById(R.id.iv_rating_user_penilaian)
        val namaUser: TextView = itemView.findViewById(R.id.tv_nama_user_penilaian)
        val ulasanUser: TextView = itemView.findViewById(R.id.tv_ulasan_user_penilaian)
    }
}