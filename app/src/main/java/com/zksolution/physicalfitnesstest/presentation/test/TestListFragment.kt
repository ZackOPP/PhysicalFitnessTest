package com.zksolution.physicalfitnesstest.presentation.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zksolution.physicalfitnesstest.presentation.common.BaseViewModelFragment
import com.zksolution.physicalfitnesstest.R

class TestListFragment : BaseViewModelFragment<TestListViewModel>() {

    override fun getViewModelClass() = TestListViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_test_list, container, false)
    }
}