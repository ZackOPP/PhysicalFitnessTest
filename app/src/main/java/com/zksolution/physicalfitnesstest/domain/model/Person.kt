package com.zksolution.physicalfitnesstest.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Person(
    var id: Int = 0,
    var firstName: String = "",
    var lastName: String = "",
    var idNumber: String = "",
    var gender: Gender = Gender.NONE,
    var birthday: Date? = null,
    var weight: String = ""
) : Parcelable

fun Person.isStored() = id != 0