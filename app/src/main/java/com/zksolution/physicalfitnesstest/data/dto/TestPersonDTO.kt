package com.zksolution.physicalfitnesstest.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "testsByPersons")
data class TestPersonDTO(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val testId: Int,
    val personId: Int
)