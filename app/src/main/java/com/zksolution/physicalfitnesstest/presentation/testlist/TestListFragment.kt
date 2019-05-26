package com.zksolution.physicalfitnesstest.presentation.testlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.zksolution.physicalfitnesstest.R
import com.zksolution.physicalfitnesstest.domain.model.Test
import com.zksolution.physicalfitnesstest.presentation.common.BaseViewModelFragment
import kotlinx.android.synthetic.main.fragment_test_list.*

class TestListFragment : BaseViewModelFragment<TestListViewModel>() {

    override fun getViewModelClass() = TestListViewModel::class.java

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_test_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureRecyclerView(view)
        test_list_fab.setOnClickListener {
            navigateToPersonEditor()
        }
    }

    private fun configureRecyclerView(view: View) {
        val testAdapter = TestAdapter{
            navigateToPersonEditor(it)
        }
        with(test_list_rv) {
            adapter = testAdapter
            layoutManager = LinearLayoutManager(view.context)
            setHasFixedSize(true)
        }
        viewModel.tests.observe(viewLifecycleOwner, Observer {
            testAdapter.setItems(it)
        })
    }

    private fun navigateToPersonEditor(test: Test = Test()) =
        findNavController().navigate(
            TestListFragmentDirections.showTestEditor(test)
        )
}