package com.zksolution.physicalfitnesstest.presentation.common

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class DataBoundListAdapter<T, V: ViewDataBinding>() : RecyclerView.Adapter<DataBoundViewHolder<V>>() {

    private var items = emptyList<T>()

    protected abstract fun createBinding(parent: ViewGroup): V
    protected abstract fun bind(binding: V, item: T)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataBoundViewHolder(createBinding(parent))

    override fun onBindViewHolder(holder: DataBoundViewHolder<V>, position: Int) {
        bind(holder.binding, getItem(position))
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<T>) {
        this.items = items
        notifyDataSetChanged()
    }

    private fun getItem(position: Int): T = items[position]
}