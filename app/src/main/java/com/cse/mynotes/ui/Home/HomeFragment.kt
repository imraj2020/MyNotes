package com.cse.mynotes.ui.Home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cse.mynotes.R
import com.cse.mynotes.databinding.FragmentHomeBinding
import com.cse.mynotes.models.Note
import com.cse.mynotes.ui.NoteAdapter
import com.cse.mynotes.ui.NoteViewModel
import com.cse.mynotes.ui.Update.UpdateFragment
import com.cse.mynotes.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) ,NoteAdapter.Listener {

    companion object {
        fun newInstance() = HomeFragment()
    }

    val viewModel: NoteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllNotes()

        viewModel.allnotes.observe(viewLifecycleOwner){
           val adapter = NoteAdapter(it,this)
            binding.noteRCV.adapter = adapter
        }


        binding.addbtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addNoteFragment)
        }
    }

    override fun notelick(note: Note) {
        val bundle = Bundle()
        bundle.putParcelable(UpdateFragment.noteKey,note)
        findNavController().navigate(R.id.action_homeFragment_to_updateFragment,bundle)
    }

    override fun deleteclick(note: Note) {
        var alertdialog = AlertDialog.Builder(requireContext())
            .setTitle("Are you Sure ?")
            .setMessage("This will delete that item.")
            .setPositiveButton("OK", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {

                    viewModel.deleteNote(note)
                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
                }
            })
            .setNegativeButton("NO", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(context, "No Clicked", Toast.LENGTH_SHORT).show()
                }
            })
        val dialog = alertdialog.create()
        dialog.show()
    }


}