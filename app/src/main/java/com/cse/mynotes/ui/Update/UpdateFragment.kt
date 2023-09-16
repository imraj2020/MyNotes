package com.cse.mynotes.ui.Update

import android.os.Build
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
import com.cse.mynotes.databinding.FragmentUpdateBinding
import com.cse.mynotes.models.Note
import com.cse.mynotes.ui.NoteViewModel
import com.cse.mynotes.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@AndroidEntryPoint
class UpdateFragment : BaseFragment<FragmentUpdateBinding>(FragmentUpdateBinding::inflate) {

    private lateinit var note: Note
    companion object {
        const val noteKey = "noteKey"


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        note = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getParcelable(noteKey, Note::class.java)!!
        } else {
            requireArguments().getParcelable(noteKey)!!
        }
    }




    val viewModel: NoteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        note.let {
            binding.etTitles.setText(it.title)
            binding.etBodys.setText(it.body)
        }


        binding.btnupdate.setOnClickListener(View.OnClickListener {

            val dateFormat = SimpleDateFormat("dd-MM-yyyy HH:mm a", Locale.US)
            val calendar = Calendar.getInstance()
            val dateandtime = dateFormat.format(calendar.time)



            note.title = binding.etTitles.text.toString()
            note.body = binding.etBodys.text.toString()
            note.time = dateandtime.toString()


            viewModel.viewModelScope.launch {
                viewModel.updateNote(note)
            }


            findNavController().popBackStack()


        })


    }



}