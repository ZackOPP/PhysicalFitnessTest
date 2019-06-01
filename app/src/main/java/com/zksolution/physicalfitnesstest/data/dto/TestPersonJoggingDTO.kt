package com.zksolution.physicalfitnesstest.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zksolution.physicalfitnesstest.domain.model.TestPersonJogging

@Entity(tableName = "testsByPersonsJogging")
data class TestPersonJoggingDTO(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val testPersonId: Int,
    val fieldDistance: String,
    val laps: String,
    val totalDistance: String
)

fun TestPersonJoggingDTO.toDomain() = TestPersonJogging(
    this.id,
    this.testPersonId,
    this.fieldDistance,
    this.laps,
    this.totalDistance
)

fun TestPersonJogging.toDto() = TestPersonJoggingDTO(
    this.id,
    this.testPersonId,
    this.fieldDistance,
    this.laps,
    this.totalDistance
)