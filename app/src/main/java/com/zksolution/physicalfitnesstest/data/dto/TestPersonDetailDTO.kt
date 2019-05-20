package com.zksolution.physicalfitnesstest.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "testsByPersonsDetails")
data class TestPersonDetailDTO(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val testPersonId: Int,
    val exerciseName: String,
    val minutes: Double,
    val repetitions: Int,
    val repByMin: Double
)