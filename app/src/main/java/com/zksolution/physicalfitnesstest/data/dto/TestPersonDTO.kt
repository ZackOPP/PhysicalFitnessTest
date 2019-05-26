package com.zksolution.physicalfitnesstest.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zksolution.physicalfitnesstest.domain.model.TestPerson

@Entity(tableName = "testsByPersons")
data class TestPersonDTO(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val testId: Int,
    val personId: Int
)

fun List<TestPersonDTO>.toDomain() = this.map { it.toDomain() }

fun TestPersonDTO.toDomain() = TestPerson(this.id, this.testId, this.personId)

fun List<TestPerson>.toDto() = this.map { it.toDto() }

fun TestPerson.toDto() = TestPersonDTO(this.id, this.testId, this.personId)