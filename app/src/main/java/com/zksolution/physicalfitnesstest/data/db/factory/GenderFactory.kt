package com.zksolution.physicalfitnesstest.data.db.factory

import com.zksolution.physicalfitnesstest.domain.model.Gender

object GenderFactory {

    private const val MALE = "M"
    private const val FEMALE = "F"

    fun get(gender: String): Gender {
        return when {
            gender.compareIgnoringCase(MALE) -> Gender.MALE
            gender.compareIgnoringCase(FEMALE) -> Gender.FEMALE
            else -> Gender.NONE
        }
    }

    fun invert(gender: Gender): String {
        return when (gender) {
            Gender.MALE -> MALE
            Gender.FEMALE -> FEMALE
            Gender.NONE -> ""
        }
    }

    private fun String.compareIgnoringCase(reference: String) = this.equals(reference, true)
}