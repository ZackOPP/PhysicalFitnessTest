package com.zksolution.physicalfitnesstest.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zksolution.physicalfitnesstest.data.dto.TestPersonDTO
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface TestPersonDao {

    @Query("SELECT * FROM testsByPersons WHERE testId = :testId")
    fun getByTestId(testId: Int): Flowable<List<TestPersonDTO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(testPersonDTO: TestPersonDTO): Completable
}