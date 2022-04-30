package com.karimsinouh.national.data.source

import com.karimsinouh.national.data.base.ExamsDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExamsRepository @Inject constructor(
    val getExams: GetExams,
    val getSubjects: GetSubjects,
    val database: ExamsDatabase,
)