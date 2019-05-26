package com.zksolution.physicalfitnesstest.domain.usecase

import com.zksolution.physicalfitnesstest.domain.model.TestPerson
import com.zksolution.physicalfitnesstest.domain.repository.TestPersonRepository
import com.zksolution.physicalfitnesstest.domain.usecase.base.UseCase
import io.reactivex.Completable
import javax.inject.Inject

class CreateTestPersonUseCase @Inject constructor(
    private val testPersonRepository: TestPersonRepository
) : UseCase<Completable, TestPerson>() {

    override fun execute(p: TestPerson) = testPersonRepository.insertToCache(p)
}