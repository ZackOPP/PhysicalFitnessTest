package com.zksolution.physicalfitnesstest.domain.repository

import com.zksolution.physicalfitnesstest.domain.model.Person
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface PersonRepository {

    fun getAll(): Flowable<List<Person>>
    fun getByIdNumber(idNumber: String): Single<Person>
    fun save(person: Person): Completable
}