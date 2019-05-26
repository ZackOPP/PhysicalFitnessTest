package com.zksolution.physicalfitnesstest.domain.usecase

import com.zksolution.physicalfitnesstest.domain.model.Test
import com.zksolution.physicalfitnesstest.domain.repository.TestRepository
import com.zksolution.physicalfitnesstest.domain.usecase.base.UseCase
import io.reactivex.Flowable
import javax.inject.Inject

class GetTestsUseCase @Inject constructor(
    private val testRepository: TestRepository
): UseCase<Flowable<List<Test>>, Void?>() {

    override fun execute(p: Void?): Flowable<List<Test>>  = testRepository.getAll()
}