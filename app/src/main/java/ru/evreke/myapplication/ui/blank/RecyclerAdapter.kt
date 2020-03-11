package ru.evreke.myapplication.ui.blank

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.evreke.myapplication.DummyData
import ru.evreke.myapplication.databinding.DummyItemBinding

class RecyclerAdapter(
    private val onClick : (DummyData) -> Unit
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private val data = mutableListOf(
        DummyData("1"),
        DummyData("2")
    )

    fun fillData(newData:List<DummyData>){
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            DummyItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).apply {
                root.setOnClickListener {
                    onClick(data!!)
                    notifyDataSetChanged()
                }
            })


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.data = data[position]
    }

    override fun getItemCount() = data.size

    class ViewHolder(val binding: DummyItemBinding) : RecyclerView.ViewHolder(binding.root)
}