package com.karimsinouh.national.data.source

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExamsRepository @Inject constructor(
    val getExams: GetExams,
    val getSubjects: GetSubjects
)