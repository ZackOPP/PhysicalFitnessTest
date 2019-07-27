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
    val repetitions: String
)

fun List<TestPersonDetailDTO>.toDomain() = this.map { it.toDomain() }

fun TestPersonDetailDTO.toDomain() = TestPersonDetail(
    this.id,
    this.testPersonId,
    this.exerciseName,
    this.minutes,
    this.repetitions
)

fun TestPersonDetail.toDto() = TestPersonDetailDTO(
    this.id,
    this.testPersonId,
    this.exerciseName,
    this.minutes,
    this.repetitions
)