package com.zksolution.physicalfitnesstest.domain.model

data class TestPersonDetail(
    var id: Int,
    val testPersonId: Int,
    var exerciseName: String,
    var minutes: String = "",
    var repetitions: String = ""
)