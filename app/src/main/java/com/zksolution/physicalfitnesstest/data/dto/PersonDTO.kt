package com.zksolution.physicalfitnesstest.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "persons")
data class PersonDTO(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var firstName: String,
    var lastName: String,
    var idNumber: String,
    val birthday: Date,
    val gender: String,
    val weight: Double
)