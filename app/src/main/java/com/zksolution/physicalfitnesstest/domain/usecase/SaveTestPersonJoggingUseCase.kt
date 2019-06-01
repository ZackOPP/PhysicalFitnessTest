package com.zksolution.physicalfitnesstest.domain.usecase

import com.zksolution.physicalfitnesstest.domain.model.TestPersonJogging
import com.zksolution.physicalfitnesstest.domain.repository.TestPersonJoggingRepository
import com.zksolution.physicalfitnesstest.domain.usecase.base.UseCase
import io.reactivex.Completable
import javax.inject.Inject

class SaveTestPersonJoggingUseCase @Inject constructor(
    private val testPersonJoggingRepository: TestPersonJoggingRepository
) : UseCase<Completable, TestPersonJogging>() {

    override fun execute(p: TestPersonJogging): Completable =
        testPersonJoggingRepository.insertToCache(p).flatMapCompletable {
            Completable.fromAction {
                p.id = it.toInt()
            }
        }
}