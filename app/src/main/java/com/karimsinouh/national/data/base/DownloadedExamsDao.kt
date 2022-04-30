package com.karimsinouh.national.data.base

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DownloadedExamsDao {

    @Query("SELECT * FROM ExamEntity ORDER BY id DESC")
    fun getAllDownloadedExams():LiveData<List<ExamEntity>>

    @Insert(entity = ExamEntity::class)
    suspend fun insert(item:ExamEntity)

    @Delete(entity = ExamEntity::class)
    suspend fun delete(item:ExamEntity)

}