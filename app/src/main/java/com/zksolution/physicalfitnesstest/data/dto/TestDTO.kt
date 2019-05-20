package com.zksolution.physicalfitnesstest.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tests")
data class TestDTO(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val date: Date
)