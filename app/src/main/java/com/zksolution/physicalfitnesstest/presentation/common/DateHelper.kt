package com.zksolution.physicalfitnesstest.presentation.common

import java.text.SimpleDateFormat
import java.util.*

object DateHelper {

    private val STANDARD_DATE_FORMAT = SimpleDateFormat("dd/MM/yyyy", Locale("es", "ES"))

    fun getDateFromString(s: String): Date = STANDARD_DATE_FORMAT.parse(s)

    fun getStringFromDate(d: Date): String = STANDARD_DATE_FORMAT.format(d)
}