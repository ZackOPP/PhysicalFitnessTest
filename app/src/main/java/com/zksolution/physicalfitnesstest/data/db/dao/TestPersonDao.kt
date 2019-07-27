package com.zksolution.physicalfitnesstest.data.db.dao

import androidx.room.*
import com.zksolution.physicalfitnesstest.data.dto.TestPersonDTO
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface TestPersonDao {

    @Query("SELECT * FROM testsByPersons WHERE testId = :testId")
    fun getByTestId(testId: Int): Flowable<List<TestPersonDTO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(testPersonDTO: TestPersonDTO): Single<Long>

    @Update
    fun update(testPersonDTO: TestPersonDTO): Completable
}