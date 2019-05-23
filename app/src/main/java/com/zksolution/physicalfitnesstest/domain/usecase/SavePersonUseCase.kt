package com.zksolution.physicalfitnesstest.domain.usecase

import com.zksolution.physicalfitnesstest.domain.exception.PendingFieldsException
import com.zksolution.physicalfitnesstest.domain.model.Person
import com.zksolution.physicalfitnesstest.domain.repository.PersonRepository
import com.zksolution.physicalfitnesstest.domain.usecase.base.UseCase
import io.reactivex.Completable
import javax.inject.Inject

class SavePersonUseCase @Inject constructor(
    private val personRepository: PersonRepository
) : UseCase<Completable, Person>() {

    override fun execute(p: Person): Completable {
        if (!isValid(p)) {
            return Completable.error(PendingFieldsException())
        }
        return personRepository.save(p)
    }

    private fun isValid(p: Person) =
        p.firstName.isNotEmpty() &&
                p.lastName.isNotEmpty() &&
                p.idNumber.isNotEmpty()
}