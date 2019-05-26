package com.zksolution.physicalfitnesstest.presentation.personlist

import android.view.LayoutInflater
import android.view.ViewGroup
import com.zksolution.physicalfitnesstest.databinding.ListItemPersonBinding
import com.zksolution.physicalfitnesstest.domain.model.Person
import com.zksolution.physicalfitnesstest.presentation.common.DataBoundListAdapter

class PersonAdapter(
    private val personClickCallback: ((Person) -> Unit)
) : DataBoundListAdapter<Person, ListItemPersonBinding>() {

    override fun bind(binding: ListItemPersonBinding, item: Person) {
        binding.person = item
    }

    override fun createBinding(parent: ViewGroup): ListItemPersonBinding {
        val binding = ListItemPersonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        binding.root.setOnClickListener {
            binding.person?.let {person ->
                personClickCallback.invoke(person)
            }
        }
        return binding
    }
}