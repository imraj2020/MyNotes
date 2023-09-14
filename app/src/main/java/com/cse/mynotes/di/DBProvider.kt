package com.cse.mynotes.di

import android.content.Context
import com.cse.mynotes.db.NoteDao
import com.cse.mynotes.db.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

class DBProvider {
    @Provides
    @Singleton
    fun dbprovider(@ApplicationContext context: Context):NoteDatabase{

        return  NoteDatabase.getInstance(context)

    }

    @Provides
    @Singleton
    fun daoprovider(db:NoteDatabase): NoteDao {

        return db.getNoteDao()
    }
}