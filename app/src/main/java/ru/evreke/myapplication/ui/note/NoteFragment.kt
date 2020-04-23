package ru.evreke.myapplication.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.notes_fragment.*
import ru.evreke.myapplication.R

class NoteFragment : Fragment() {
    private val model: NoteFragmentViewModel by viewModels()
    private val adapter = NoteRecyclerAdapter { }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.notes_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        model.data.observe(viewLifecycleOwner, Observer { adapter.fillData(it) })
        model.getData()
    }
}
