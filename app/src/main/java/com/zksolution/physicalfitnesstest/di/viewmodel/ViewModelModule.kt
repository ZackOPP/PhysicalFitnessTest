package com.zksolution.physicalfitnesstest.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zksolution.physicalfitnesstest.presentation.personeditor.PersonEditorViewModel
import com.zksolution.physicalfitnesstest.presentation.personlist.PersonListViewModel
import com.zksolution.physicalfitnesstest.presentation.testdetail.TestDetailViewModel
import com.zksolution.physicalfitnesstest.presentation.testlist.TestListViewModel
import com.zksolution.physicalfitnesstest.presentation.testpersondetail.TestPersonDetailViewModel
import com.zksolution.physicalfitnesstest.presentation.testpersonjogging.TestPersonJoggingViewModel
import com.zksolution.physicalfitnesstest.presentation.testresult.TestResultViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PersonListViewModel::class)
    abstract fun bindPersonListViewModel(personListViewModel: PersonListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PersonEditorViewModel::class)
    abstract fun bindPersonEditorViewModel(personEditorViewModel: PersonEditorViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TestListViewModel::class)
    abstract fun bindTestListViewModel(testListViewModel: TestListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TestDetailViewModel::class)
    abstract fun bindTestDetailViewModel(testDetailViewModel: TestDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TestPersonJoggingViewModel::class)
    abstract fun bindTestPersonJoggingViewModelClass(testPersonJoggingViewModel: TestPersonJoggingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TestPersonDetailViewModel::class)
    abstract fun bindTestPersonDetailViewModel(testPersonDetailViewModel: TestPersonDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TestResultViewModel::class)
    abstract fun bindTestResultViewModel(testResultViewModel: TestResultViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}