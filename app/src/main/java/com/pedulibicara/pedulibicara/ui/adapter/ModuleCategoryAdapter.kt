package com.pedulibicara.pedulibicara.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.pedulibicara.pedulibicara.data.model.ModuleCategory
import com.pedulibicara.pedulibicara.databinding.ModuleCardViewBinding

class ModuleCategoryAdapter(
    private val listModuleCategory: List<ModuleCategory>
) : RecyclerView.Adapter<ModuleCategoryAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(moduleCategory: ModuleCategory)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ViewHolder(
        var binding: ModuleCardViewBinding
        ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ModuleCardViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = listModuleCategory[position]

        holder.binding.apply {
            Glide.with(holder.itemView.context)
                .load(category.thumbnail)
                .apply(RequestOptions().override(100, 100))
                .into(ivModuleImage)
            tvModuleTitle.text = category.title
            tvModuleDescription.text = category.description
        }

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(category)
        }
    }

    override fun getItemCount(): Int = listModuleCategory.count()
}