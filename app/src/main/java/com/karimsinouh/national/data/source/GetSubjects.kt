package com.karimsinouh.national.data.source

import com.karimsinouh.national.data.Subject
import kotlinx.coroutines.delay
import javax.inject.Inject

class GetSubjects @Inject constructor() {

    suspend operator fun invoke(
        listener:(Result<List<Subject>>)->Unit
    ){
        delay(3000)
        listener(Result.success(emptyList()))
    }

}