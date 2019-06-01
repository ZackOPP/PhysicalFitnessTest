package com.zksolution.physicalfitnesstest.presentation.testdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.TextInputEditText
import com.zksolution.physicalfitnesstest.R
import com.zksolution.physicalfitnesstest.presentation.common.BaseViewModelFragment
import kotlinx.android.synthetic.main.fragment_test_detail.*

class TestDetailFragment : BaseViewModelFragment<TestDetailViewModel>() {

    override fun getViewModelClass() = TestDetailViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_test_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecyclerView(view)
        val safeArgs = TestDetailFragmentArgs.fromBundle(arguments!!)
        viewModel.loadTestData(safeArgs.test)
        test_detail_fab.setOnClickListener {
            displayAddPersonAlertDialog()
        }
        viewModel.addedTestPerson.observe(viewLifecycleOwner, Observer {
            if (it != null){
                viewModel.addedTestPerson.value = null
                findNavController().navigate(
                    TestDetailFragmentDirections.showForm(it)
                )
            }
        })
    }

    private fun configureRecyclerView(view: View) {
        val testDetailAdapter = TestDetailAdapter()
        with(test_detail_rv) {
            adapter = testDetailAdapter
            layoutManager = LinearLayoutManager(view.context)
            setHasFixedSize(true)
        }
        viewModel.testPersonList.observe(viewLifecycleOwner, Observer {
            testDetailAdapter.setItems(it)
        })
    }

    private fun displayAddPersonAlertDialog() {
        context?.let {
            val viewInflated = LayoutInflater.from(it)
                .inflate(R.layout.view_text_input_id_number, view as ViewGroup?, false)
            val input = viewInflated.findViewById<TextInputEditText>(R.id.text_input_id_number_value)
            AlertDialog.Builder(it)
                .setTitle(getString(R.string.add_person))
                .setView(viewInflated)
                .setPositiveButton(R.string.ok) { _, _ ->
                    input?.text?.let { inputValue ->
                        viewModel.addPersonById(inputValue.toString())
                    }
                }.show()
        }
    }
}