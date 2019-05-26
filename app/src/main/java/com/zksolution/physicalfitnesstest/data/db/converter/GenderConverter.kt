package com.zksolution.physicalfitnesstest.data.db.converter

import androidx.room.TypeConverter
import com.zksolution.physicalfitnesstest.data.db.factory.GenderFactory
import com.zksolution.physicalfitnesstest.domain.model.Gender

object GenderConverter {

    @TypeConverter
    @JvmStatic
    fun toGender(value: String) = GenderFactory.get(value)

    @TypeConverter
    @JvmStatic
    fun toString(value: Gender) = GenderFactory.getInverted(value)
}