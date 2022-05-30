package com.pedulibicara.pedulibicara.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pedulibicara.pedulibicara.databinding.ModuleCardViewBinding
import com.pedulibicara.pedulibicara.model.ModuleCategory

class ModuleCategoryAdapter(
    private var listCategory: List<ModuleCategory>
) : RecyclerView.Adapter<ModuleCategoryAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(category: ModuleCategory)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(var binding: ModuleCardViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ModuleCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val category = listCategory[position]

        holder.binding.apply {

            Glide.with(holder.itemView.context)
                .load(category.picture)
                .apply(RequestOptions().override(100, 100))
                .into(ivModuleImage)

            tvModuleTitle.text = category.title
            tvModuleDescription.text = category.description

        }

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(
                listCategory[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listCategory.count()
}