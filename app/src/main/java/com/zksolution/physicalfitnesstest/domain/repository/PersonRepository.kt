package com.zksolution.physicalfitnesstest.domain.repository

import com.zksolution.physicalfitnesstest.data.dto.PersonDTO
import io.reactivex.Completable
import io.reactivex.Single

interface PersonRepository {

    fun getAll(): Single<List<PersonDTO>>

    fun save(personDTO: PersonDTO): Completable
}