package com.zksolution.physicalfitnesstest.presentation.person

import androidx.lifecycle.ViewModel
import com.zksolution.physicalfitnesstest.domain.model.Person
import javax.inject.Inject

class PersonViewModel @Inject constructor() : ViewModel() {

    var selectedPerson = Person()
        set(value) {
            field = value.copy()
        }
}