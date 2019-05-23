package com.zksolution.physicalfitnesstest.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zksolution.physicalfitnesstest.domain.model.Person
import java.util.*

@Entity(tableName = "persons")
data class PersonDTO(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val firstName: String,
    val lastName: String,
    val idNumber: String,
    val gender: String,
    val birthday: Date,
    val weight: String
)

fun List<PersonDTO>.toDomain() = this.map { it.toDomain() }

fun PersonDTO.toDomain() = Person(id, firstName, lastName, idNumber, gender, birthday, weight)

fun List<Person>.toDto() = this.map { it.toDto() }

fun Person.toDto() = PersonDTO(this.id, this.firstName, this.lastName, this.idNumber, this.gender, this.birthday, this.weight)