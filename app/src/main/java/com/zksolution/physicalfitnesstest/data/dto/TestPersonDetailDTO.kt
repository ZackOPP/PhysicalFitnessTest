package com.zksolution.physicalfitnesstest.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zksolution.physicalfitnesstest.domain.model.TestPersonDetail

@Entity(tableName = "testsByPersonsDetails")
data class TestPersonDetailDTO(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val testPersonId: Int,
    val exerciseName: String,
    val minutes: String,
    val repetitions: String,
    val repByMin: String
)

fun TestPersonDetailDTO.toDomain() = TestPersonDetail(
    this.id,
    this.testPersonId,
    this.exerciseName,
    this.minutes,
    this.repetitions,
    this.repByMin
)

fun TestPersonDetail.toDto() = TestPersonDetailDTO(
    this.id,
    this.testPersonId,
    this.exerciseName,
    this.minutes,
    this.repetitions,
    this.repByMin
)