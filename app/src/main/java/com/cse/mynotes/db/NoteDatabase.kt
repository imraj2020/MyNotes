package com.cse.mynotes.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cse.mynotes.models.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase:RoomDatabase() {

    abstract fun getNoteDao():NoteDao


    companion object {

        private var db: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase {

            return if (db == null) {

                db = Room
                    .databaseBuilder(
                        context,
                        NoteDatabase::class.java,
                        "notes_db"
                    ).build()

                db as NoteDatabase

            } else {
                db as NoteDatabase

            }

        }
    }

}