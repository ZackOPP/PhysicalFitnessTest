package com.zksolution.physicalfitnesstest.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Test(
    var id: Int = 0,
    var date: Date = Date(),
    var numberOfPersons: Int = 0
) : Parcelable

fun Test.isStored() = this.id != 0