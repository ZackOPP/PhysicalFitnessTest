package com.zksolution.physicalfitnesstest.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class ExerciseDTO(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String
)