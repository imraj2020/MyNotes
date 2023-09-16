package com.cse.mynotes.ui.AddNote

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.cse.mynotes.R
import com.cse.mynotes.databinding.FragmentAddNoteBinding
import com.cse.mynotes.databinding.FragmentHomeBinding
import com.cse.mynotes.models.Note
import com.cse.mynotes.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@AndroidEntryPoint
class AddNoteFragment : BaseFragment<FragmentAddNoteBinding>(FragmentAddNoteBinding::inflate)  {

    companion object {
        fun newInstance() = AddNoteFragment()
    }

    val viewModel: AddNoteViewModel by viewModels()




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val dateFormat = SimpleDateFormat("dd-MM-yyyy hh:mm a", Locale.US)
        val calendar = Calendar.getInstance()
        val dateandtime = dateFormat.format(calendar.time)





        binding.btnSave.setOnClickListener {

            val note = Note(
                0,
                binding.etTitle.text.toString(),
                binding.etBody.text.toString(),
                dateandtime
            )
            viewModel.viewModelScope.launch {
                viewModel.insertNote(note)
            }

            findNavController().navigate(R.id.action_addNoteFragment_to_homeFragment)
        }
    }




}