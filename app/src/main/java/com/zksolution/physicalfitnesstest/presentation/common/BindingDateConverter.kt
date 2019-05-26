package com.zksolution.physicalfitnesstest.presentation.common

import androidx.databinding.InverseMethod
import java.util.*

object BindingDateConverter {

    @InverseMethod("stringToDate")
    @JvmStatic fun dateToString(value: Date?) = value?.run { DateHelper.getStringFromDate(this) }

    @JvmStatic fun stringToDate(value: String) = DateHelper.getDateFromString(value)
}