package com.zksolution.physicalfitnesstest.presentation.personlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zksolution.physicalfitnesstest.domain.model.Person
import com.zksolution.physicalfitnesstest.domain.usecase.GetPersonsUseCase
import com.zksolution.physicalfitnesstest.presentation.common.RxViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class PersonListViewModel @Inject constructor(
    private val getPersonsUseCase: GetPersonsUseCase
) : RxViewModel() {

    private val _persons: MutableLiveData<List<Person>> = MutableLiveData()
    val persons: LiveData<List<Person>>
        get() = _persons

    init {
        loadPersons()
    }

    private fun loadPersons() =
        addDisposable(getPersonsUseCase.execute(null)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _persons.value = it
            }, {
                Log.e(TAG, "loadPersons()", it)
            }))
}

private const val TAG = "PersonListViewModel"