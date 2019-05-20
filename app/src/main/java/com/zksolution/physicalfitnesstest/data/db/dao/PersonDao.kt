package com.zksolution.physicalfitnesstest.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zksolution.physicalfitnesstest.data.dto.PersonDTO
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(person: List<PersonDTO>): Completable

    @Query("SELECT * FROM persons WHERE idNumber = :idNumber")
    fun getByIdNumber(idNumber: String): Single<PersonDTO>
}