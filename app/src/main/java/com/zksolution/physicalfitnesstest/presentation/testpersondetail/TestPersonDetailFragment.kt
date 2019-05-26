package com.zksolution.physicalfitnesstest.presentation.testpersondetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zksolution.physicalfitnesstest.R
import com.zksolution.physicalfitnesstest.presentation.common.BaseViewModelFragment

class TestPersonDetailFragment : BaseViewModelFragment<TestPersonDetailViewModel>() {

    override fun getViewModelClass() = TestPersonDetailViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_exercise_form, container, false)
    }
}