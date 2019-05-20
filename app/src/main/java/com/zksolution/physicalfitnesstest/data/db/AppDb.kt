package com.zksolution.physicalfitnesstest.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zksolution.physicalfitnesstest.data.db.converter.DateConverter
import com.zksolution.physicalfitnesstest.data.db.dao.*
import com.zksolution.physicalfitnesstest.data.dto.*

@Database(version = 1,
    exportSchema = false,
    entities = [
        PersonDTO::class,
        TestDTO::class,
        TestPersonDTO::class,
        TestPersonDetailDTO::class,
        TestPersonJoggingDTO::class,
        ExerciseDTO::class
    ]
)
@TypeConverters(DateConverter::class)
abstract class AppDb : RoomDatabase() {
    abstract fun personDao(): PersonDao
    abstract fun testDao(): TestDao
    abstract fun testPersonDao(): TestPersonDao
    abstract fun testPersonDetailDao(): TestPersonDetailDao
    abstract fun testPersonJoggingDao(): TestPersonJoggingDao
}