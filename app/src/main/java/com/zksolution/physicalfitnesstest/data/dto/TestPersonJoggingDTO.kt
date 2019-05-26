package com.zksolution.physicalfitnesstest.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "testsByPersonsJogging")
data class TestPersonJoggingDTO(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val testPersonId: Int,
    val fieldDistance: String,
    val laps: String,
    val totalDistance: String
)