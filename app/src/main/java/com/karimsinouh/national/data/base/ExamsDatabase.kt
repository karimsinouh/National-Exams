package com.karimsinouh.national.data.base

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [ExamEntity::class])
abstract class ExamsDatabase:RoomDatabase() {

    abstract fun downloadedExams():DownloadedExamsDao

}