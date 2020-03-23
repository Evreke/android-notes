package ru.evreke.myapplication.ui.blank

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.evreke.myapplication.Group
import ru.evreke.myapplication.databinding.GroupItemBinding

class RecyclerAdapter(
    private val onClick : (Group) -> Unit
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private val data = mutableListOf<Group>()

    fun fillData(newData:List<Group>){
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            GroupItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).apply {
                root.setOnClickListener {
                    group?.let(onClick)
                }
            })


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.group = data[position]
    }

    override fun getItemCount() = data.size

    class ViewHolder(val binding: GroupItemBinding) : RecyclerView.ViewHolder(binding.root)
}