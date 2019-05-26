package com.zksolution.physicalfitnesstest.domain.usecase

import com.zksolution.physicalfitnesstest.domain.model.Test
import com.zksolution.physicalfitnesstest.domain.repository.TestRepository
import com.zksolution.physicalfitnesstest.domain.usecase.base.UseCase
import io.reactivex.Single
import javax.inject.Inject

class CreateTestUseCase @Inject constructor(
    private val testRepository: TestRepository
) : UseCase<Single<Long>, Test>() {

    override fun execute(p: Test) =
        testRepository.insertToCache(p)
}