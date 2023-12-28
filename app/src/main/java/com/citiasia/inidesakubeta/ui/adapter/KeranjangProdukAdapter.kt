    package com.citiasia.inidesakubeta.ui.adapter

    import PasarDesaViewModel
    import android.content.Intent
    import android.util.Log
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.CheckBox
    import android.widget.ImageButton
    import android.widget.ImageView
    import android.widget.TextView
    import androidx.core.content.ContextCompat
    import androidx.core.os.bundleOf
    import androidx.lifecycle.LifecycleOwner
    import androidx.recyclerview.widget.RecyclerView
    import com.bumptech.glide.Glide
    import com.citiasia.inidesakubeta.R
    import com.citiasia.inidesakubeta.data.database.Produk
    import com.citiasia.inidesakubeta.model.KeranjangProdukDummy
    import com.citiasia.inidesakubeta.model.RekomendasiProdukDummy
    import com.citiasia.inidesakubeta.ui.pasar_desa.DetailProdukActivity
    import com.google.android.material.button.MaterialButton


    interface OnItemCheckedListener {
        fun onItemChecked(isChecked: Boolean)
    }
    class KeranjangProdukAdapter(
        private val listKeranjangProduk: ArrayList<KeranjangProdukDummy>,
        private val onItemCheckedListener: OnItemCheckedListener) : RecyclerView.Adapter<KeranjangProdukAdapter.ListViewHolder>() {
        private lateinit var onItemClickCallback: OnItemClickCallback

        fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
            val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_keranjang, parent, false)
            return ListViewHolder(view)
        }

        override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

            val (produk, isSelected) = listKeranjangProduk[position]
            holder.tvJumlahProduk.text = produk.jumlah.toString()

            var jumlahProduk = produk.jumlah.toString().toInt()

            holder.kurangProdukBtn.setOnClickListener {
                if (jumlahProduk > 1) {
                    jumlahProduk--
                    holder.tvJumlahProduk.text = jumlahProduk.toString()
                } else if (jumlahProduk < 1) {
                    holder.kurangProdukBtn.isEnabled = false
                }
            }

            holder.tambahProdukBtn.setOnClickListener {
                jumlahProduk++
                holder.tvJumlahProduk.text = jumlahProduk.toString()
            }

            holder.pilihProdukBtn.setOnClickListener { v ->
                val isChecked = (v as CheckBox).isChecked
                listKeranjangProduk[holder.adapterPosition].isSelected = isChecked
                onItemCheckedListener.onItemChecked(isChecked)
            }

            Glide.with(holder.itemView.context)
                .load(produk.fotoProduk)
                .into(holder.imgFotoProduk)
            holder.tvNamaProduk.text = produk.namaProduk
            holder.tvHargaProduk.text = produk.hargaProduk
            holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listKeranjangProduk[holder.adapterPosition]) }
        }

        override fun getItemCount(): Int = listKeranjangProduk.size

        inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imgFotoProduk: ImageView = itemView.findViewById(R.id.imageProduct)
            val tvNamaProduk: TextView = itemView.findViewById(R.id.textProductName)
            val tvHargaProduk: TextView = itemView.findViewById(R.id.textProductPrice)
            val kurangProdukBtn: ImageButton = itemView.findViewById(R.id.kurangProdukBtn)
            val tambahProdukBtn: ImageButton = itemView.findViewById(R.id.tambahProdukBtn)
            val tvJumlahProduk: TextView = itemView.findViewById(R.id.tvJumlahProduk)
            val pilihProdukBtn: CheckBox = itemView.findViewById(R.id.chooseItem)
        }

        interface OnItemClickCallback {
            fun onItemClicked(data: KeranjangProdukDummy)
        }
    }