package com.cse.mynotes.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cse.mynotes.databinding.ItemNoteBinding
import com.cse.mynotes.models.Note
import javax.inject.Inject

class NoteAdapter @Inject constructor(
    private var notelist: List<Note>,
    private var listener: Listener
) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    interface Listener {

        fun notelick(note: Note)
        fun deleteclick(note: Note)
    }


    inner class NoteViewHolder(val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val noteViewHolder = NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )

        return noteViewHolder
    }

    override fun getItemCount(): Int {
        return notelist.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        val contact = notelist[position]

        holder.binding.dateandtimeTv.text = contact.time
        holder.binding.TitleTv.text = contact.title
        holder.binding.bodyTv.text = contact.body

        holder.binding.bodyTv.text = if (contact.body.length <= 100) {
            contact.body
        } else {
            contact.body.substring(0, 25)
        }



            holder.itemView.setOnClickListener(View.OnClickListener {
            listener.notelick(contact)
        })

        holder.binding.deletebtn.setOnClickListener {
            listener.deleteclick(contact)
        }


    }


}