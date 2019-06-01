package com.zksolution.physicalfitnesstest.domain.repository

import com.zksolution.physicalfitnesstest.domain.model.Exercise
import io.reactivex.Maybe
import io.reactivex.Single

interface ExerciseRepository {
    fun getFirst(): Single<Exercise>
    fun getNext(exercise: Exercise): Maybe<Exercise>
}