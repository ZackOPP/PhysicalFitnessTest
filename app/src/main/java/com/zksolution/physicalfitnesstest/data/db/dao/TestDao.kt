package com.zksolution.physicalfitnesstest.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zksolution.physicalfitnesstest.data.dto.TestDTO
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface TestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(test: TestDTO): Single<Long>

    @Query("SELECT * FROM tests")
    fun getAll(): Flowable<List<TestDTO>>
}