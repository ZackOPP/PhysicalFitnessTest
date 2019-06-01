package com.zksolution.physicalfitnesstest.di

import com.zksolution.physicalfitnesstest.data.db.dao.*
import com.zksolution.physicalfitnesstest.data.repository.*
import com.zksolution.physicalfitnesstest.domain.repository.*
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

    @Provides
    @Reusable
    fun provideTestPersonDetailRepository(testPersonDetailDao: TestPersonDetailDao): TestPersonDetailRepository =
            TestPersonDetailRepositoryImpl(testPersonDetailDao)

    @Provides
    @Reusable
    fun provideExerciseRepository(): ExerciseRepository = ExerciseRepositoryImpl()

    @Provides
    @Reusable
    fun provideTestPersonJoggingRepository(testPersonJoggingDao: TestPersonJoggingDao): TestPersonJoggingRepository =
            TestPersonJoggingRepositoryImpl(testPersonJoggingDao)
}