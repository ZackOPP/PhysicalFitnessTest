package com.zksolution.physicalfitnesstest.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.zksolution.physicalfitnesstest.data.dto.TestPersonDetailDTO
import io.reactivex.Single

@Dao
interface TestPersonDetailDao {

    @Insert
    fun insert(testPersonDetailDTO: TestPersonDetailDTO): Single<Long>
}