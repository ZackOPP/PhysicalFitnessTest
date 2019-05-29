package com.zksolution.physicalfitnesstest.domain.repository

import com.zksolution.physicalfitnesstest.domain.model.TestPerson
import io.reactivex.Flowable
import io.reactivex.Single

interface TestPersonRepository {

    fun getByTestId(testId: Int): Flowable<List<TestPerson>>
    fun insertToCache(testPerson: TestPerson): Single<Long>
}