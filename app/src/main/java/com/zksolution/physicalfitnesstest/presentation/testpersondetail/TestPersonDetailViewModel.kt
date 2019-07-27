package com.zksolution.physicalfitnesstest.presentation.testpersondetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zksolution.physicalfitnesstest.domain.model.*
import com.zksolution.physicalfitnesstest.domain.usecase.GetNextExerciseUseCase
import com.zksolution.physicalfitnesstest.domain.usecase.SaveTestPersonDetailUseCase
import com.zksolution.physicalfitnesstest.presentation.common.RxViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TestPersonDetailViewModel @Inject constructor(
    private val getNextExerciseUseCase: GetNextExerciseUseCase,
    private val saveTestPersonDetailUseCase: SaveTestPersonDetailUseCase
) : RxViewModel() {

    lateinit var testPersonDetail: TestPersonDetail
    private lateinit var currentExercise: Exercise

    var nextExercise: Exercise? = null
    lateinit var testPerson: TestPerson

    private val _repetitionsByMinute = MutableLiveData<String>()
    val repetitionsByMinute: LiveData<String> = _repetitionsByMinute

    fun loadTestData(tp: TestPerson, e: Exercise) {
        if (!::testPersonDetail.isInitialized) {
            currentExercise = e
            testPerson = tp
            testPersonDetail = TestPersonDetail(0, tp.id, currentExercise.name)
        }
    }

    fun loadNextExercise() =
        addDisposable(getNextExerciseUseCase.execute(currentExercise)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                nextExercise = it
            }, {
                nextExercise = null
            })
        )

    fun save() =
        addDisposable(saveTestPersonDetailUseCase.execute(testPersonDetail)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            }, {

            })
        )

    fun onDetailsChanged() =
        with (testPersonDetail) {
            _repetitionsByMinute.value = if (repetitions.isNotEmpty() && minutes.isNotEmpty()) {
                (repetitions.toDouble() / minutes.toDouble()).toString()
            } else {
                "0"
            }
        }
}