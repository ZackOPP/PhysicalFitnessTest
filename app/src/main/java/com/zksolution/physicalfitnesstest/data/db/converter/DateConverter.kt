package com.zksolution.physicalfitnesstest.data.db.converter

import androidx.room.TypeConverter
import java.util.*

object DateConverter {

    @TypeConverter
    @JvmStatic
    fun toDate(timestamp: Long?) = timestamp?.run { Date(this) }

    @TypeConverter
    @JvmStatic
    fun toTimestamp(date: Date?) = date?.time
}