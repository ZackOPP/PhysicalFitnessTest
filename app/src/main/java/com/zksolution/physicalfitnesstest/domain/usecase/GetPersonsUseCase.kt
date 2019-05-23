package com.zksolution.physicalfitnesstest.domain.usecase

import com.zksolution.physicalfitnesstest.domain.model.Person
import com.zksolution.physicalfitnesstest.domain.repository.PersonRepository
import com.zksolution.physicalfitnesstest.domain.usecase.base.UseCase
import io.reactivex.Flowable
import javax.inject.Inject

class GetPersonsUseCase @Inject constructor(
    private val personRepository: PersonRepository
) : UseCase<Flowable<List<Person>>, Void?>() {

    override fun execute(p: Void?) = personRepository.getAll()
}