package com.zksolution.physicalfitnesstest.presentation.testpersonjogging

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.zksolution.physicalfitnesstest.R
import com.zksolution.physicalfitnesstest.databinding.FragmentJoggingFormBinding
import com.zksolution.physicalfitnesstest.presentation.common.BaseViewModelFragment
import kotlinx.android.synthetic.main.view_button_next_question.*

class TestPersonJoggingFragment : BaseViewModelFragment<TestPersonJoggingViewModel>() {

    override fun getViewModelClass() = TestPersonJoggingViewModel::class.java

    private lateinit var binding: FragmentJoggingFormBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_jogging_form, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs =  TestPersonJoggingFragmentArgs.fromBundle(arguments!!)
        viewModel.loadTestData(safeArgs.testPerson)
        binding.viewModel = viewModel
        view_button_next_question_btn.setOnClickListener {
            viewModel.save()
            findNavController().navigate(
                TestPersonJoggingFragmentDirections.nextExerciseDest(viewModel.firstExercise, viewModel.testPerson)
            )
        }
    }
}