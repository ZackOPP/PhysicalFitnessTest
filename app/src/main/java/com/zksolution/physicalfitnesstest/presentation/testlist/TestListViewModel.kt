package com.zksolution.physicalfitnesstest.presentation.testlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zksolution.physicalfitnesstest.domain.model.Test
import com.zksolution.physicalfitnesstest.domain.usecase.GetTestsUseCase
import com.zksolution.physicalfitnesstest.presentation.common.RxViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class TestListViewModel @Inject constructor(
    private val getTestsUseCase: GetTestsUseCase
) : RxViewModel() {

    private val _tests: MutableLiveData<List<Test>> = MutableLiveData()
    val tests: LiveData<List<Test>>
        get() = _tests

    init {
        loadTests()
    }

    private fun loadTests() =
        addDisposable(getTestsUseCase.execute(null)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _tests.value = it
            }, {
                Log.e(TAG, "loadTests()", it)
            }))
}

private const val TAG = "TestListViewModel"