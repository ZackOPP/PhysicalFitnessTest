package com.zksolution.physicalfitnesstest.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.zksolution.physicalfitnesstest.data.dto.TestPersonJoggingDTO
import io.reactivex.Single

@Dao
interface TestPersonJoggingDao {

    @Insert
    fun insert(testPersonJoggingDTO: TestPersonJoggingDTO): Single<Long>
}