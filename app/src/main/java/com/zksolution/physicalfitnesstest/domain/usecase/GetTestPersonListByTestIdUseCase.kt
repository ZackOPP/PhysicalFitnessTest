package com.zksolution.physicalfitnesstest.domain.usecase

import com.zksolution.physicalfitnesstest.domain.model.TestPerson
import com.zksolution.physicalfitnesstest.domain.repository.PersonRepository
import com.zksolution.physicalfitnesstest.domain.repository.TestPersonRepository
import com.zksolution.physicalfitnesstest.domain.repository.TestRepository
import com.zksolution.physicalfitnesstest.domain.usecase.base.UseCase
import io.reactivex.Flowable
import javax.inject.Inject

class GetTestPersonListByTestIdUseCase @Inject constructor(
    private val testPersonRepository: TestPersonRepository,
    private val testRepository: TestRepository,
    private val personRepository: PersonRepository
) : UseCase<Flowable<List<TestPerson>>, Int>() {

    override fun execute(p: Int): Flowable<List<TestPerson>> {
        return testPersonRepository.getByTestId(p)
        // TODO (Add Test and Person entities)
    }
}