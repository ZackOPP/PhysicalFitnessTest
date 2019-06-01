package com.zksolution.physicalfitnesstest.presentation.testpersonjogging

import com.zksolution.physicalfitnesstest.domain.model.Exercise
import com.zksolution.physicalfitnesstest.domain.model.TestPerson
import com.zksolution.physicalfitnesstest.domain.model.TestPersonJogging
import com.zksolution.physicalfitnesstest.domain.repository.ExerciseRepository
import com.zksolution.physicalfitnesstest.domain.usecase.SaveTestPersonJoggingUseCase
import com.zksolution.physicalfitnesstest.presentation.common.RxViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TestPersonJoggingViewModel @Inject constructor(
    private val exerciseRepository: ExerciseRepository,
    private val saveTestPersonJoggingUseCase: SaveTestPersonJoggingUseCase
) : RxViewModel() {

    lateinit var firstExercise: Exercise

    lateinit var testPersonJogging: TestPersonJogging
    lateinit var testPerson: TestPerson

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