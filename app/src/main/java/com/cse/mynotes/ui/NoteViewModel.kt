package com.cse.mynotes.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cse.mynotes.models.Note
import com.cse.mynotes.repos.NoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private  val repo: NoteRepo) : ViewModel() {

    private var _allnotes : MutableLiveData<List<Note>> = MutableLiveData<List<Note>>()

    val allnotes : LiveData<List<Note>> get() = _allnotes


    fun getAllNotes() {

        viewModelScope.launch{

            _allnotes.postValue(repo.getAllNotes())
        }
    }


    fun deleteNote(note: Note){
        viewModelScope.launch {
            repo.deleteNote(note)
            getAllNotes()
        }
    }


    fun updateNote(note: Note){
        viewModelScope.launch {
            repo.updateNote(note)
            getAllNotes()
        }

    }




}