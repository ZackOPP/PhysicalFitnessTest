package com.zksolution.physicalfitnesstest.presentation.person

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zksolution.physicalfitnesstest.presentation.common.BaseViewModelFragment
import com.zksolution.physicalfitnesstest.R

class PersonListFragment : BaseViewModelFragment<PersonListViewModel>() {

    override fun getViewModelClass() = PersonListViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_person_list, container, false)
    }
}