package com.zksolution.physicalfitnesstest.domain.repository

import com.zksolution.physicalfitnesstest.domain.model.Test
import io.reactivex.Flowable
import io.reactivex.Single

interface TestRepository {

    fun getAll(): Flowable<List<Test>>
    fun insertToCache(test: Test): Single<Long>
}