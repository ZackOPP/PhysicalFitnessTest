package com.zksolution.physicalfitnesstest.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zksolution.physicalfitnesstest.presentation.person.PersonListViewModel
import com.zksolution.physicalfitnesstest.presentation.test.TestListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PersonListViewModel::class)
    abstract fun bindPersonListViewModel(personListViewModel: PersonListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TestListViewModel::class)
    abstract fun bindTestListViewModel(testListViewModel: TestListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}