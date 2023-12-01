package com.citiasia.inidesakubeta.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.BantuanData

class BantuanAdapter(private var mList: List<BantuanData>) :
    RecyclerView.Adapter<BantuanAdapter.BantuanViewHolder>() {

        inner class BantuanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val title: TextView = itemView.findViewById(R.id.titleHelp)
            val desc: TextView = itemView.findViewById(R.id.descHelp)
            val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.layoutItem)

            fun collapseExpandedView(){
                desc.visibility = View.GONE
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BantuanViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.bantuan_item, parent, false)
            return BantuanViewHolder(view)
        }

        override fun onBindViewHolder(holder: BantuanViewHolder, position: Int) {

            val bantuanData = mList[position]
            holder.title.text = bantuanData.title
            holder.desc.text = bantuanData.desc

            val isExpandable: Boolean =  bantuanData.isExpandable
            holder.desc.visibility = if (isExpandable) View.VISIBLE else View.GONE

            holder.constraintLayout.setOnClickListener {
                isAnyItemExpanded(position)
                bantuanData.isExpandable = !bantuanData.isExpandable
                notifyItemChanged(position , Unit)
            }

        }

        private fun isAnyItemExpanded(position: Int){
            val temp = mList.indexOfFirst {
                it.isExpandable
            }
            if (temp >= 0 && temp != position){
                mList[temp].isExpandable = false
                notifyItemChanged(temp , 0)
            }
        }

        override fun onBindViewHolder(
            holder: BantuanViewHolder,
            position: Int,
            payloads: MutableList<Any>
        ) {

            if(payloads.isNotEmpty() && payloads[0] == 0){
                holder.collapseExpandedView()
            }else{
                super.onBindViewHolder(holder, position, payloads)

            }
        }

        override fun getItemCount(): Int {
            return mList.size
        }
}