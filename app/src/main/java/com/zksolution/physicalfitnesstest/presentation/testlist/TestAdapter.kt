package com.zksolution.physicalfitnesstest.presentation.testlist

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zksolution.physicalfitnesstest.databinding.ListItemTestBinding
import com.zksolution.physicalfitnesstest.domain.model.Test
import com.zksolution.physicalfitnesstest.presentation.common.DataBoundListAdapter

class TestAdapter(
    private val testClickCallback: ((Test) -> Unit)
) : DataBoundListAdapter<Test, ListItemTestBinding>() {

    override fun bind(binding: ListItemTestBinding, item: Test) {
        binding.test = item
    }

    override fun createBinding(parent: ViewGroup): ListItemTestBinding {
        val binding = ListItemTestBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        binding.root.setOnClickListener {
            binding.test?.let {test ->
                testClickCallback.invoke(test)
            }
        }
        return binding
    }
}