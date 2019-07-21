package com.zksolution.physicalfitnesstest.presentation.testpersonjogging

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zksolution.physicalfitnesstest.domain.model.Exercise
import com.zksolution.physicalfitnesstest.domain.model.TestPerson
import com.zksolution.physicalfitnesstest.domain.model.TestPersonJogging
import com.zksolution.physicalfitnesstest.domain.repository.ExerciseRepository
import com.zksolution.physicalfitnesstest.domain.usecase.SaveTestPersonJoggingUseCase
import com.zksolution.physicalfitnesstest.presentation.common.RxViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import kotlin.math.roundToLong

class TestPersonJoggingViewModel @Inject constructor(
    private val exerciseRepository: ExerciseRepository,
    private val saveTestPersonJoggingUseCase: SaveTestPersonJoggingUseCase
) : RxViewModel() {

    lateinit var firstExercise: Exercise

    lateinit var testPersonJogging: TestPersonJogging
    lateinit var testPerson: TestPerson

    private val _totalDistance = MutableLiveData<String>()
    val totalDistance: LiveData<String> = _totalDistance

    init {
        loadFirstExercise()
    }

    fun loadTestData(t: TestPerson) {
        if (!::testPersonJogging.isInitialized) {
            testPerson = t
            testPersonJogging = TestPersonJogging(0, testPerson.id)
        }
    }

    fun save() =
        addDisposable(saveTestPersonJoggingUseCase.execute(testPersonJogging)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            }, {

            }))

    fun onJoggingDetailsChanged() =
        with (testPersonJogging) {
            _totalDistance.value = if (fieldDistance.isNotEmpty() && laps.isNotEmpty()) {
                (fieldDistance.toDouble() * laps.toDouble()).toString()
            } else {
                "0"
            }
        }

    private fun loadFirstExercise() =
        addDisposable(exerciseRepository.getFirst()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                firstExercise = it
            }, {

            })
        )
}