package com.zksolution.physicalfitnesstest.di

import com.zksolution.physicalfitnesstest.data.db.dao.PersonDao
import com.zksolution.physicalfitnesstest.data.db.dao.TestDao
import com.zksolution.physicalfitnesstest.data.db.dao.TestPersonDao
import com.zksolution.physicalfitnesstest.data.repository.PersonRepositoryImpl
import com.zksolution.physicalfitnesstest.data.repository.TestPersonRepositoryImpl
import com.zksolution.physicalfitnesstest.data.repository.TestRepositoryImpl
import com.zksolution.physicalfitnesstest.domain.repository.PersonRepository
import com.zksolution.physicalfitnesstest.domain.repository.TestPersonRepository
import com.zksolution.physicalfitnesstest.domain.repository.TestRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class RepositoryModule {

    @Provides
    @Reusable
    fun providePersonRepository(personDao: PersonDao): PersonRepository = PersonRepositoryImpl(personDao)

    @Provides
    @Reusable
    fun provideTestRepository(testDao: TestDao): TestRepository = TestRepositoryImpl(testDao)

    @Provides
    @Reusable
    fun provideTestPersonRepository(testPersonDao: TestPersonDao): TestPersonRepository = TestPersonRepositoryImpl(testPersonDao)

}