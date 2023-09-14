package com.cse.mynotes.ui.AddNote

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.cse.mynotes.R
import com.cse.mynotes.databinding.FragmentAddNoteBinding
import com.cse.mynotes.databinding.FragmentHomeBinding
import com.cse.mynotes.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment : BaseFragment<FragmentAddNoteBinding>(FragmentAddNoteBinding::inflate)  {

    companion object {
        fun newInstance() = AddNoteFragment()
    }

    val viewModel: AddNoteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}