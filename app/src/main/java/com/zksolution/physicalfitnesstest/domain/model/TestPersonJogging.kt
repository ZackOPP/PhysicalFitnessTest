package com.zksolution.physicalfitnesstest.domain.model

data class TestPersonJogging(
    var id: Int,
    val testPersonId: Int,
    var fieldDistance: String = "",
    var laps: String = "",
    var totalDistance: String = ""
)