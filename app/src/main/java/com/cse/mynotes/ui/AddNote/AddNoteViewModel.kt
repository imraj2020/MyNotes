package com.cse.mynotes.ui.AddNote

import androidx.lifecycle.ViewModel
import com.cse.mynotes.repos.NoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(private val repo: NoteRepo) : ViewModel() {
    // TODO: Implement the ViewModel
}