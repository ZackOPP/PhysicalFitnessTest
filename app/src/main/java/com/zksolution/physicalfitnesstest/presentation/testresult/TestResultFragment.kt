package com.zksolution.physicalfitnesstest.presentation.testresult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.zksolution.physicalfitnesstest.R
import kotlinx.android.synthetic.main.view_button_next_question.*

class TestResultFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_test_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view_button_next_question_btn.setOnClickListener {
            findNavController().popBackStack(R.id.test_detail_dest, false)
        }
    }
}