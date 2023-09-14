package com.cse.mynotes.repos

import com.cse.mynotes.db.NoteDao
import com.cse.mynotes.models.Note
import javax.inject.Inject

class NoteRepo @Inject constructor (private val dao: NoteDao) {


        suspend fun getAllNotes():List<Note> {

            return dao.getAllNotes()
        }

        suspend fun insertNote(note: Note) {
            dao.insert(note)
        }

        suspend fun deleteNote(note: Note) {
            dao.delete(note)
        }

        suspend fun updateNote(note: Note) {
            dao.update(note)
        }


}