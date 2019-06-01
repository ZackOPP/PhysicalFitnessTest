package com.zksolution.physicalfitnesstest.data.repository

import com.zksolution.physicalfitnesstest.data.db.dao.TestPersonDetailDao
import com.zksolution.physicalfitnesstest.data.dto.toDto
import com.zksolution.physicalfitnesstest.domain.model.TestPersonDetail
import com.zksolution.physicalfitnesstest.domain.repository.TestPersonDetailRepository
import io.reactivex.Single

class TestPersonDetailRepositoryImpl (
    private val testPersonDetailDao: TestPersonDetailDao
): TestPersonDetailRepository {

    override fun insertToCache(testPersonDetail: TestPersonDetail): Single<Long> =
        testPersonDetailDao.insert(testPersonDetail.toDto())
}