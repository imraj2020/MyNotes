package com.cse.mynotes.ui.Home

import androidx.lifecycle.ViewModel
import com.cse.mynotes.repos.NoteRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private  val repo: NoteRepo) : ViewModel() {

}