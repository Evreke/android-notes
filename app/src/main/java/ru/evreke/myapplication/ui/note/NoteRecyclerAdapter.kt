package ru.evreke.myapplication.ui.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.evreke.myapplication.data.model.Note
import ru.evreke.myapplication.databinding.NoteItemBinding

class NoteRecyclerAdapter(
    private val onClick: (Note) -> Unit
) : RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>() {
    private val data = mutableListOf<Note>()

    fun fillData(newData: List<Note>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            NoteItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).apply {
                root.setOnClickListener {
                    note?.let(onClick)
                }
            })


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.note = data[position]
    }

    override fun getItemCount() = data.size

    class ViewHolder(val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root)
}