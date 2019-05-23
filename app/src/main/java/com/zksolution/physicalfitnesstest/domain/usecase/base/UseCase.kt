package com.zksolution.physicalfitnesstest.domain.usecase.base

abstract class UseCase<R, P> {
    abstract fun execute(p: P): R
}