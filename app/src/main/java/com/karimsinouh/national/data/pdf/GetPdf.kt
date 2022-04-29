package com.karimsinouh.national.data.pdf

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetPdf @Inject constructor(
    val remote: GetRemotePdf,
    val localPdf: GetLocalPdf
)
