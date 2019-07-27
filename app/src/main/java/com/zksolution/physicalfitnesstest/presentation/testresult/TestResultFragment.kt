package com.zksolution.physicalfitnesstest.presentation.testresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.zksolution.physicalfitnesstest.R
import com.zksolution.physicalfitnesstest.databinding.FragmentTestResultBinding
import com.zksolution.physicalfitnesstest.presentation.common.BaseViewModelFragment
import kotlinx.android.synthetic.main.view_button_next_question.*

class TestResultFragment : BaseViewModelFragment<TestResultViewModel>() {

    private lateinit var binding: FragmentTestResultBinding

    override fun getViewModelClass() = TestResultViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test_result, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val safeArgs =  TestResultFragmentArgs.fromBundle(arguments!!)
        binding.viewModel = viewModel
        viewModel.loadData(safeArgs.testPerson)
        view_button_next_question_btn.setOnClickListener {
            findNavController().popBackStack(R.id.test_detail_dest, false)
        }
    }
}