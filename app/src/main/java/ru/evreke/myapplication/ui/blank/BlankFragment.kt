package ru.evreke.myapplication.ui.blank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_blank.*
import ru.evreke.myapplication.R

class BlankFragment : Fragment() {
    private val model: BlankFragmentViewModel by viewModels()
    private val adapter = RecyclerAdapter {
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_blank, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        model.getData().observe(viewLifecycleOwner, Observer {
            adapter.fillData(it)
        })
    }

}
