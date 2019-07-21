package com.zksolution.physicalfitnesstest.presentation.personeditor

import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import android.widget.RadioGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zksolution.physicalfitnesstest.R
import com.zksolution.physicalfitnesstest.domain.exception.PendingFieldsException
import com.zksolution.physicalfitnesstest.domain.model.Gender
import com.zksolution.physicalfitnesstest.domain.model.Person
import com.zksolution.physicalfitnesstest.domain.usecase.SavePersonUseCase
import com.zksolution.physicalfitnesstest.presentation.common.RxViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PersonEditorViewModel @Inject constructor(
    private val savePersonUseCase: SavePersonUseCase
) : RxViewModel() {

    lateinit var person: Person

    private val _successfullySaved: MutableLiveData<Boolean> = MutableLiveData()
    val successfullySaved: LiveData<Boolean>
        get() = _successfullySaved

    private val _savedMessage: MutableLiveData<Int> = MutableLiveData()
    val savedMessage: LiveData<Int>
        get() = _savedMessage

    private val _errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: LiveData<Int>
        get() = _errorMessage

    fun onGenderCheckedChanged(id: Int) {
        person.gender = when (id) {
            R.id.person_editor_female_rb -> Gender.FEMALE
            R.id.person_editor_male_rb -> Gender.MALE
            else -> Gender.NONE
        }
    }

    fun getInitialSelectedGender() =
            when (person.gender) {
                Gender.FEMALE -> R.id.person_editor_female_rb
                Gender.MALE -> R.id.person_editor_male_rb
                Gender.NONE -> null
            }

    fun trySavePerson() =
        addDisposable(savePersonUseCase.execute(person)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _savedMessage.value = R.string.person_successfully_saved
                _successfullySaved.value = true
            }, {
                onSaveError(it)
                _successfullySaved.value = false
            }))

    private fun onSaveError(t: Throwable) {
        Log.e(TAG, "onSaveError", t)
        _errorMessage.value = when (t) {
            is PendingFieldsException -> R.string.pending_fields_error_message
            is SQLiteConstraintException -> R.string.id_number_exists_error_message
            else -> R.string.generic_error_try_again
        }
    }
}

private const val TAG = "PersonEditorViewModel"