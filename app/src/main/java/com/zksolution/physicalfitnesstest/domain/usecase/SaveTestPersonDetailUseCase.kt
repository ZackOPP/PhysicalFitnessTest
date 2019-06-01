package com.zksolution.physicalfitnesstest.domain.usecase

import com.zksolution.physicalfitnesstest.domain.model.TestPersonDetail
import com.zksolution.physicalfitnesstest.domain.repository.TestPersonDetailRepository
import com.zksolution.physicalfitnesstest.domain.usecase.base.UseCase
import io.reactivex.Completable
import javax.inject.Inject

class SaveTestPersonDetailUseCase @Inject constructor(
    private val testPersonDetailRepository: TestPersonDetailRepository
) : UseCase<Completable, TestPersonDetail>() {

    override fun execute(p: TestPersonDetail): Completable =
        testPersonDetailRepository.insertToCache(p).flatMapCompletable {
            Completable.fromAction {
                p.id = it.toInt()
            }
        }
}