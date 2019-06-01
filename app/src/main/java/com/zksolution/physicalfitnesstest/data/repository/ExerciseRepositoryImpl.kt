package com.zksolution.physicalfitnesstest.data.repository

import com.zksolution.physicalfitnesstest.domain.model.Exercise
import com.zksolution.physicalfitnesstest.domain.repository.ExerciseRepository
import io.reactivex.Maybe
import io.reactivex.Single

class ExerciseRepositoryImpl : ExerciseRepository {

    private val exerciseList = listOf(
        Exercise(1, "Abdominales"),
        Exercise(2, "Flexiones"),
        Exercise(3, "Combinado naval")
    )

    override fun getFirst(): Single<Exercise> =
        Single.fromCallable {
            exerciseList.first()
        }

    override fun getNext(exercise: Exercise): Maybe<Exercise> =
        Maybe.fromCallable {
            exerciseList.find {
                it.id > exercise.id
            }
        }
}