package com.zksolution.physicalfitnesstest.presentation.testpersondetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.zksolution.physicalfitnesstest.R
import com.zksolution.physicalfitnesstest.databinding.FragmentExerciseFormBinding
import com.zksolution.physicalfitnesstest.databinding.FragmentJoggingFormBinding
import com.zksolution.physicalfitnesstest.domain.model.Exercise
import com.zksolution.physicalfitnesstest.presentation.common.BaseViewModelFragment
import kotlinx.android.synthetic.main.view_button_next_question.*

class TestPersonDetailFragment : BaseViewModelFragment<TestPersonDetailViewModel>() {

    private lateinit var binding: FragmentExerciseFormBinding

    override fun getViewModelClass() = TestPersonDetailViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_exercise_form, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs =  TestPersonDetailFragmentArgs.fromBundle(arguments!!)
        viewModel.loadTestData(safeArgs.testPerson, safeArgs.exercise)
        binding.testPersonDetail = viewModel.testPersonDetail
        viewModel.loadNextExercise()
        view_button_next_question_btn.setOnClickListener {
            viewModel.save()
            if (viewModel.nextExercise == null) {
                navigateToTestResult()
            } else {
                navigateToNextExercise()
            }
        }
    }

    private fun navigateToNextExercise() =
        findNavController().navigate(
            TestPersonDetailFragmentDirections.nextExerciseDest(viewModel.nextExercise!!, viewModel.testPerson)
        )

    private fun navigateToTestResult() =
        findNavController().navigate(
            TestPersonDetailFragmentDirections.finishDest()
        )
}