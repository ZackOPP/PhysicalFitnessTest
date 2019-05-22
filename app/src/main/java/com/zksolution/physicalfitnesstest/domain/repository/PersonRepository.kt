package com.zksolution.physicalfitnesstest.domain.repository

import com.zksolution.physicalfitnesstest.domain.model.Person
import io.reactivex.Completable
import io.reactivex.Single

interface PersonRepository {

    fun getAll(): Single<List<Person>>

    fun save(person: Person): Completable
}