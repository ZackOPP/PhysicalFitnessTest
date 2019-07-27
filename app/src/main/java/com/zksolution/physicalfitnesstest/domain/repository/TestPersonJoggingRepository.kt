package com.zksolution.physicalfitnesstest.domain.repository

import com.zksolution.physicalfitnesstest.domain.model.TestPerson
import com.zksolution.physicalfitnesstest.domain.model.TestPersonJogging
import io.reactivex.Single

interface TestPersonJoggingRepository {
    fun insertToCache(testPersonJogging: TestPersonJogging): Single<Long>
    fun getByTestPerson(testPerson: TestPerson): Single<TestPersonJogging>
}