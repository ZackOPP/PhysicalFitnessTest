package com.zksolution.physicalfitnesstest.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zksolution.physicalfitnesstest.domain.model.Test
import java.util.*

@Entity(tableName = "tests")
data class TestDTO(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val date: Date
)

fun List<TestDTO>.toDomain() = this.map { it.toDomain() }

fun TestDTO.toDomain() = Test(this.id, this.date)

fun List<Test>.toDto() = this.map { it.toDto() }

fun Test.toDto() = TestDTO(this.id, this.date)