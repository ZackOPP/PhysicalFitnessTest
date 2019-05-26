package com.zksolution.physicalfitnesstest.data.repository

import com.zksolution.physicalfitnesstest.data.db.dao.TestDao
import com.zksolution.physicalfitnesstest.data.dto.toDomain
import com.zksolution.physicalfitnesstest.data.dto.toDto
import com.zksolution.physicalfitnesstest.domain.model.Test
import com.zksolution.physicalfitnesstest.domain.repository.TestRepository
import io.reactivex.Flowable
import io.reactivex.Single

class TestRepositoryImpl(
    private val testDao: TestDao
) : TestRepository {

    override fun getAll(): Flowable<List<Test>> =
        testDao.getAll().map {
            it.toDomain()
        }

    override fun insertToCache(test: Test): Single<Long> = testDao.insert(test.toDto())
}