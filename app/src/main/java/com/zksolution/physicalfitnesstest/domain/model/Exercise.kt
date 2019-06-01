package com.zksolution.physicalfitnesstest.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Exercise(
    val id: Int,
    val name: String
) : Parcelable