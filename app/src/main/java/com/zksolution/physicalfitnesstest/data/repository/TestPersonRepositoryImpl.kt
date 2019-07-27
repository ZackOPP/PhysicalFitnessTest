package com.zksolution.physicalfitnesstest.data.repository

import com.zksolution.physicalfitnesstest.data.db.dao.TestPersonDao
import com.zksolution.physicalfitnesstest.data.dto.toDomain
import com.zksolution.physicalfitnesstest.data.dto.toDto
import com.zksolution.physicalfitnesstest.domain.model.TestPerson
import com.zksolution.physicalfitnesstest.domain.repository.TestPersonRepository
import io.reactivex.Flowable

class TestPersonRepositoryImpl (
    private val testPersonDao: TestPersonDao
) :TestPersonRepository {

    override fun getByTestId(testId: Int): Flowable<List<TestPerson>> =
        testPersonDao.getByTestId(testId).map {
            it.toDomain()
        }

    override fun insertToCache(testPerson: TestPerson) = testPersonDao.insert(testPerson.toDto())

    override fun updateInCache(testPerson: TestPerson) = testPersonDao.update(testPerson.toDto())
}