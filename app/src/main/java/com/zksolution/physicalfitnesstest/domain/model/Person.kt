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
    var gender: String = "",
    var birthday: Date = Date(),
    var weight: String = ""
) : Parcelable