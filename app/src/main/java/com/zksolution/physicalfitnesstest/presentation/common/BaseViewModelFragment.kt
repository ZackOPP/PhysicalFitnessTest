package com.zksolution.physicalfitnesstest.presentation.common

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.zksolution.physicalfitnesstest.App
import javax.inject.Inject


abstract class BaseViewModelFragment<VM: ViewModel> : Fragment() {

    private val viewModelFactoryWrapper = ViewModelFactoryWrapper()

    protected lateinit var viewModel: VM
        private set

    protected abstract fun getViewModelClass(): Class<VM>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.appComponent.inject(viewModelFactoryWrapper)
        viewModel = fetchViewModel()
    }

    private fun fetchViewModel() =
        ViewModelProviders.of(this, viewModelFactoryWrapper.viewModelFactory)
            .get(getViewModelClass())
}

class ViewModelFactoryWrapper {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
}