package com.zksolution.physicalfitnesstest.di

import android.app.Application
import androidx.room.Room
import com.zksolution.physicalfitnesstest.data.db.AppDb
import com.zksolution.physicalfitnesstest.di.viewmodel.ViewModelModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideDb(app: Application) : AppDb {
        return Room
            .databaseBuilder(app, AppDb::class.java, "physical_fitness_test.db")
            .build()
    }

    @Singleton
    @Provides
    fun providePersonDao(db: AppDb) = db.personDao()

    @Singleton
    @Provides
    fun provideTestDao(db: AppDb) = db.testDao()

    @Singleton
    @Provides
    fun provideTestPersonDao(db: AppDb) = db.testPersonDao()

    @Singleton
    @Provides
    fun provideTestPersonDetailDao(db: AppDb) = db.testPersonDetailDao()

    @Singleton
    @Provides
    fun provideTestPersonJoggingDao(db: AppDb) = db.testPersonJoggingDao()
}