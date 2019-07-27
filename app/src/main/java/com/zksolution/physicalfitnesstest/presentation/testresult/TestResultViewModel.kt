package com.zksolution.physicalfitnesstest.presentation.testresult

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zksolution.physicalfitnesstest.domain.model.TestPerson
import com.zksolution.physicalfitnesstest.domain.usecase.GenerateTestResultByTestPersonUseCase
import com.zksolution.physicalfitnesstest.presentation.common.RxViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TestResultViewModel @Inject constructor(
    private val generateTestResultByTestPersonUseCase : GenerateTestResultByTestPersonUseCase
) : RxViewModel() {

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    private val _resultInt = MutableLiveData<Int>()
    val resultInt: LiveData<Int> = _resultInt


    fun loadData(t: TestPerson) = addDisposable(
        generateTestResultByTestPersonUseCase
            .execute(t)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _result.value = "${t.result}%"
                _resultInt.value = t.result.toInt()
            }, {

            })
    )
}