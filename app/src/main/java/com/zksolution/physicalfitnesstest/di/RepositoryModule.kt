package com.zksolution.physicalfitnesstest.di

import com.zksolution.physicalfitnesstest.data.db.dao.PersonDao
import com.zksolution.physicalfitnesstest.data.repository.PersonRepositoryImpl
import com.zksolution.physicalfitnesstest.domain.repository.PersonRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class RepositoryModule {

    @Provides
    @Reusable
    fun providePersonRepository(personDao: PersonDao): PersonRepository = PersonRepositoryImpl(personDao)

}