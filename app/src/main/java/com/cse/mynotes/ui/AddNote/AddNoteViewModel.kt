package com.cse.mynotes.ui.AddNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cse.mynotes.models.Note
import com.cse.mynotes.repos.NoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(private val repo: NoteRepo) : ViewModel() {

    suspend fun insertNote(note: Note){

        viewModelScope.launch {
            repo.insertNote(note)
        }
    }
}