package com.zksolution.physicalfitnesstest.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TestPerson(
    var id: Int,
    val testId: Int,
    val personId: Int,
    val test: Test? = null,
    val person: Person? = null,
    var result: Double = 0.toDouble()
) : Parcelable