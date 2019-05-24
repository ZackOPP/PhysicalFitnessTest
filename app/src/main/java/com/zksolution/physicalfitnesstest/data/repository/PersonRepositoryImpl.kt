package com.zksolution.physicalfitnesstest.data.repository

import com.zksolution.physicalfitnesstest.data.db.dao.PersonDao
import com.zksolution.physicalfitnesstest.data.dto.toDomain
import com.zksolution.physicalfitnesstest.data.dto.toDto
import com.zksolution.physicalfitnesstest.domain.model.Person
import com.zksolution.physicalfitnesstest.domain.repository.PersonRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class PersonRepositoryImpl(
    private val personDao: PersonDao
) : PersonRepository {

    override fun getAll(): Flowable<List<Person>> =
        personDao.getAll().map {
            it.toDomain()
        }

    override fun getByIdNumber(idNumber: String): Single<Person> =
        personDao.getByIdNumber(idNumber).map {
            it.toDomain()
        }

    override fun save(person: Person): Completable {
        val p = person.toDto()
        return if (p.id == 0)
            personDao.insert(p)
        else
            personDao.update(p)
    }
}