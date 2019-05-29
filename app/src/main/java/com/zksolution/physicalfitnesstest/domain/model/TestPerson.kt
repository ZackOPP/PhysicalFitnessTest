package com.zksolution.physicalfitnesstest.domain.model

data class TestPerson(
    var id: Int,
    val testId: Int,
    val personId: Int,
    val test: Test? = null,
    val person: Person? = null
)