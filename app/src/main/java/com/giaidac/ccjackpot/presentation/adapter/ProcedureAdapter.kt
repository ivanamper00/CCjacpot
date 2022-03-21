package com.giaidac.ccjackpot.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giaidac.ccjackpot.domain.SicboAssets
import com.giaidac.common.DataContent
import com.giaidac.ccjackpot.databinding.ItemProcedureBinding

class ProcedureAdapter(var onClickListener: OnClickListener): RecyclerView.Adapter<ProcedureAdapter.ViewHolder>() {

    var procedures = SicboAssets.getProcedures()
    class ViewHolder(var binding: ItemProcedureBinding): RecyclerView.ViewHolder(binding.root) { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProcedureBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.procedure = procedures[position]
        holder.binding.root.setOnClickListener {
            onClickListener.onItemClick(procedures[position])
        }
    }

    override fun getItemCount(): Int = procedures.size

    interface OnClickListener {
        fun onItemClick(content: DataContent)
    }
}