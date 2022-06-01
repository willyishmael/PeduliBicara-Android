package com.pedulibicara.pedulibicara.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pedulibicara.pedulibicara.data.model.ModuleItem
import com.pedulibicara.pedulibicara.databinding.ModuleItemViewBinding

class ModuleItemAdapter(
    private val listModuleItem: List<ModuleItem>
) : RecyclerView.Adapter<ModuleItemAdapter.ViewHolder>(){

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(item: ModuleItem)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ViewHolder(var binding: ModuleItemViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ModuleItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listModuleItem[position]

        holder.binding.apply {

            Glide.with(holder.itemView.context)
                .load(item.image)
                .apply(RequestOptions().override(100, 100))
                .into(ivItemImage)

        }

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(item)
        }
    }

    override fun getItemCount(): Int = listModuleItem.count()
}