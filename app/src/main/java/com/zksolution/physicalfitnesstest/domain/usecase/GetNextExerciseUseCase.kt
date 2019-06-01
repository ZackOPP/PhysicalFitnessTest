package com.zksolution.physicalfitnesstest.domain.usecase

import com.zksolution.physicalfitnesstest.domain.model.Exercise
import com.zksolution.physicalfitnesstest.domain.repository.ExerciseRepository
import com.zksolution.physicalfitnesstest.domain.usecase.base.UseCase
import io.reactivex.Maybe
import javax.inject.Inject

class GetNextExerciseUseCase @Inject constructor(
    private val exerciseRepository: ExerciseRepository
) : UseCase<Maybe<Exercise>, Exercise>() {

    override fun execute(p: Exercise): Maybe<Exercise> =
        exerciseRepository.getNext(p)
}