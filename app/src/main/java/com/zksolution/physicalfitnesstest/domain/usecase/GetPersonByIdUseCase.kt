package com.zksolution.physicalfitnesstest.domain.usecase

import com.zksolution.physicalfitnesstest.domain.model.Person
import com.zksolution.physicalfitnesstest.domain.repository.PersonRepository
import com.zksolution.physicalfitnesstest.domain.usecase.base.UseCase
import io.reactivex.Single
import javax.inject.Inject

class GetPersonByIdUseCase @Inject constructor(
    private val personRepository: PersonRepository
) : UseCase<Single<Person>, String>() {

    override fun execute(p: String) = personRepository.getByIdNumber(p)
}