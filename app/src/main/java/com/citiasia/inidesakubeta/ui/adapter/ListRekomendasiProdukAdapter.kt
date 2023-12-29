package com.citiasia.inidesakubeta.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.model.RekomendasiProdukDummy
import com.citiasia.inidesakubeta.ui.pasar_desa.DetailProdukActivity


class ListRekomendasiProdukAdapter(private val listRekomendasiProduk: ArrayList<RekomendasiProdukDummy>) : RecyclerView.Adapter<ListRekomendasiProdukAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_pasar_desa, parent, false)
        return ListViewHolder(view)
    }

    @Suppress("DEPRECATION")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (foto, nama, harga, deskripsi, iconNilai, nilai, terjual) = listRekomendasiProduk[position]
        Glide.with(holder.itemView.context)
            .load(foto)
            .into(holder.imgFotoProduk)
        Glide.with(holder.itemView.context)
            .load(iconNilai)
            .into(holder.iconNilaiProduk)
        holder.tvNamaProduk.text = nama
        holder.tvHargaProduk.text = "Rp. " + harga
        holder.tvDeskripsiProduk.text = deskripsi
        holder.tvNilaiProduk.text = nilai
        holder.tvProdukTerjual.text = terjual
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailProdukActivity::class.java)
            intentDetail.putExtra("key_item", listRekomendasiProduk[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listRekomendasiProduk.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgFotoProduk: ImageView = itemView.findViewById(R.id.imageProduct)
        val tvNamaProduk: TextView = itemView.findViewById(R.id.textProductName)
        val tvHargaProduk: TextView = itemView.findViewById(R.id.textProductPrice)
        val tvDeskripsiProduk: TextView = itemView.findViewById(R.id.textDeskripsiProduk)
        val tvNilaiProduk: TextView = itemView.findViewById(R.id.textRating)
        val iconNilaiProduk: ImageView = itemView.findViewById(R.id.iconNilaiProduk)
        val tvProdukTerjual: TextView = itemView.findViewById(R.id.textTerjual)
    }
}