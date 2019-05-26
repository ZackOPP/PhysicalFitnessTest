package com.zksolution.physicalfitnesstest.domain.repository

import com.zksolution.physicalfitnesstest.domain.model.TestPerson
import io.reactivex.Completable
import io.reactivex.Flowable

interface TestPersonRepository {

    fun getByTestId(testId: Int): Flowable<List<TestPerson>>
    fun insertToCache(testPerson: TestPerson): Completable
}