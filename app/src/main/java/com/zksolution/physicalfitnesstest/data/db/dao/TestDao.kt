package com.zksolution.physicalfitnesstest.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.zksolution.physicalfitnesstest.data.dto.TestDTO
import io.reactivex.Completable

@Dao
interface TestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(tests: List<TestDTO>): Completable
}