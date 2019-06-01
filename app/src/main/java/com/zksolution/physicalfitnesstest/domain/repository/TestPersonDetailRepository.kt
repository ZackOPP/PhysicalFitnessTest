package com.zksolution.physicalfitnesstest.domain.repository

import com.zksolution.physicalfitnesstest.domain.model.TestPersonDetail
import io.reactivex.Single

interface TestPersonDetailRepository {
    fun insertToCache(testPersonDetail: TestPersonDetail): Single<Long>
}