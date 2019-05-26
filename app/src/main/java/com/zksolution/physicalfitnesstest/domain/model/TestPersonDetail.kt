package com.zksolution.physicalfitnesstest.domain.model

data class TestPersonDetail(
    val testPersonId: Int,
    var exerciseName: String,
    var minutes: String,
    var repetitions: String,
    var repByMin: String
)