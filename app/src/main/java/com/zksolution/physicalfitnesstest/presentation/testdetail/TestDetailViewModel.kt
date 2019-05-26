package com.zksolution.physicalfitnesstest.presentation.testdetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.EmptyResultSetException
import com.zksolution.physicalfitnesstest.domain.model.Person
import com.zksolution.physicalfitnesstest.domain.model.Test
import com.zksolution.physicalfitnesstest.domain.model.TestPerson
import com.zksolution.physicalfitnesstest.domain.model.isStored
import com.zksolution.physicalfitnesstest.domain.usecase.CreateTestPersonUseCase
import com.zksolution.physicalfitnesstest.domain.usecase.CreateTestUseCase
import com.zksolution.physicalfitnesstest.domain.usecase.GetPersonByIdUseCase
import com.zksolution.physicalfitnesstest.domain.usecase.GetTestPersonListByTestIdUseCase
import com.zksolution.physicalfitnesstest.presentation.common.RxViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TestDetailViewModel @Inject constructor(
    private val getTestPersonListByTestIdUseCase: GetTestPersonListByTestIdUseCase,
    private val createTestUseCase: CreateTestUseCase,
    private val getPersonByIdUseCase: GetPersonByIdUseCase,
    private val createTestPersonUseCase: CreateTestPersonUseCase
) : RxViewModel() {

    private lateinit var test: Test

    private val _testPersonList: MutableLiveData<List<TestPerson>> = MutableLiveData()
    val testPersonList: LiveData<List<TestPerson>>
        get() = _testPersonList

    val personAddedSuccessfully: MutableLiveData<Boolean> = MutableLiveData()

    fun loadTestData(t: Test) {
        if (!::test.isInitialized) {
            this.test = t
        }
        if (!test.isStored()) {
            addDisposable(
                createTestUseCase.execute(test)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        test.id = it.toInt()
                        loadTestPersonListByTestId()
                    }, {
                        Log.e(TAG, "loadTestData() test -> $t", it)
                    })
            )
        }
    }

    fun addPersonById(id: String) =
        addDisposable(
            getPersonByIdUseCase.execute(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    addPerson(it)
                }, {
                    if (it is EmptyResultSetException) {
                        // TODO ( Display error message )
                    }
                    Log.e(TAG, "addPersonById() id -> $id", it)
                })
        )

    private fun addPerson(person: Person) =
        addDisposable(
            createTestPersonUseCase.execute(TestPerson(0, test.id, person.id))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    personAddedSuccessfully.value = true
                }, {
                    Log.e(TAG, "addPerson() person -> $person", it)
                })
        )

    private fun loadTestPersonListByTestId() {
        if (testPersonList.value == null) {
            addDisposable(
                getTestPersonListByTestIdUseCase.execute(test.id)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        _testPersonList.value = it
                    }, {
                        Log.e(TAG, "loadTestPersonList()", it)
                    })
            )
        }
    }
}

private const val TAG = "TestDetailViewModel"