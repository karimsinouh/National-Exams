package com.karimsinouh.national.di

import android.app.DownloadManager
import android.content.Context
import androidx.room.Room
import com.karimsinouh.national.data.base.ExamsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SingletonsModule {

    @Provides
    fun provideDownloadManager(@ApplicationContext context: Context)
    =context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

    @Provides
    fun provideDatabase(@ApplicationContext context: Context)
    = Room.databaseBuilder(context,ExamsDatabase::class.java,"exams").build()

}