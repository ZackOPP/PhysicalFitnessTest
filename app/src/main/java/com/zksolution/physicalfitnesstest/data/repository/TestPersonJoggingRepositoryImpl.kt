package com.zksolution.physicalfitnesstest.data.repository

import com.zksolution.physicalfitnesstest.data.db.dao.TestPersonJoggingDao
import com.zksolution.physicalfitnesstest.data.dto.toDomain
import com.zksolution.physicalfitnesstest.data.dto.toDto
import com.zksolution.physicalfitnesstest.domain.model.TestPerson
import com.zksolution.physicalfitnesstest.domain.model.TestPersonJogging
import com.zksolution.physicalfitnesstest.domain.repository.TestPersonJoggingRepository
import io.reactivex.Single

class TestPersonJoggingRepositoryImpl (
    private val testPersonJoggingDao: TestPersonJoggingDao
) : TestPersonJoggingRepository {

    override fun insertToCache(testPersonJogging: TestPersonJogging): Single<Long> =
        testPersonJoggingDao.insert(testPersonJogging.toDto())

    override fun getByTestPerson(testPerson: TestPerson): Single<TestPersonJogging> =
        testPersonJoggingDao.getByTestPersonId(testPerson.id).map { it.toDomain() }
}