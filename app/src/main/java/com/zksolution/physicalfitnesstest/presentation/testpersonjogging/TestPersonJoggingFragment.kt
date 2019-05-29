package com.zksolution.physicalfitnesstest.presentation.testpersonjogging

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.zksolution.physicalfitnesstest.R
import com.zksolution.physicalfitnesstest.presentation.common.BaseViewModelFragment
import kotlinx.android.synthetic.main.view_button_next_question.*

class TestPersonJoggingFragment : BaseViewModelFragment<TestPersonJoggingViewModel>() {

    override fun getViewModelClass() = TestPersonJoggingViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_jogging_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view_button_next_question_btn.setOnClickListener {
            findNavController().navigate(
                TestPersonJoggingFragmentDirections.nextExerciseDest()
            )
        }
    }
}