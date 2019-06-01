package com.zksolution.physicalfitnesstest.domain.usecase

import com.zksolution.physicalfitnesstest.domain.model.Exercise
import com.zksolution.physicalfitnesstest.domain.repository.ExerciseRepository
import com.zksolution.physicalfitnesstest.domain.usecase.base.UseCase
import io.reactivex.Single
import javax.inject.Inject

class GetFirstExerciseUseCase @Inject constructor(
    private val exerciseRepository: ExerciseRepository
) : UseCase<Single<Exercise>, Void?>() {

    override fun execute(p: Void?): Single<Exercise> =
        exerciseRepository.getFirst()
}