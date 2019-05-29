package com.zksolution.physicalfitnesstest.domain.usecase

import com.zksolution.physicalfitnesstest.domain.model.Test
import com.zksolution.physicalfitnesstest.domain.repository.TestRepository
import com.zksolution.physicalfitnesstest.domain.usecase.base.UseCase
import io.reactivex.Completable
import javax.inject.Inject

class CreateTestUseCase @Inject constructor(
    private val testRepository: TestRepository
) : UseCase<Completable, Test>() {

    override fun execute(p: Test): Completable =
        testRepository.insertToCache(p).flatMapCompletable {
            Completable.fromAction {
                p.id = it.toInt()
            }
        }
}