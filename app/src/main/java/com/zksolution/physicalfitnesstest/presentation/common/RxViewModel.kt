package com.zksolution.physicalfitnesstest.presentation.common

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class RxViewModel : ViewModel() {

    private val disposable = CompositeDisposable()

    protected fun addDisposable(d: Disposable) = disposable.add(d)

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}