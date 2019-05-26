package com.zksolution.physicalfitnesstest.presentation.testdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zksolution.physicalfitnesstest.databinding.ListItemTestPersonBinding
import com.zksolution.physicalfitnesstest.domain.model.TestPerson
import com.zksolution.physicalfitnesstest.presentation.common.DataBoundListAdapter

class TestDetailAdapter : DataBoundListAdapter<TestPerson, ListItemTestPersonBinding>() {

    override fun createBinding(parent: ViewGroup) =
        ListItemTestPersonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

    override fun bind(binding: ListItemTestPersonBinding, item: TestPerson) {
        binding.testPerson = item
    }
}