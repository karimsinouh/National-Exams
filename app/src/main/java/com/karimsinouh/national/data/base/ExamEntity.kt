package com.karimsinouh.national.data.base

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class ExamEntity(
    val title:String,
    val downloadReferenceId:Long,
    @PrimaryKey(autoGenerate = true) val id:Int=0
)
