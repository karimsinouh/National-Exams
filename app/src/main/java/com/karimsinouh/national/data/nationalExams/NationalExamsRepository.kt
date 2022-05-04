package com.karimsinouh.national.data.nationalExams

import com.karimsinouh.national.data.base.ExamsDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NationalExamsRepository @Inject constructor(
    val getExams: GetNationalExams,
    val getSubjects: GetNationalSubjects,
    val database: ExamsDatabase,
)