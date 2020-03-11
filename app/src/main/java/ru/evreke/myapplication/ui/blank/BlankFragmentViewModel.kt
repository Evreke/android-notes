package ru.evreke.myapplication.ui.blank

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.evreke.myapplication.DummyData

class BlankFragmentViewModel : ViewModel() {
    private val data: MutableLiveData<List<DummyData>> by lazy {
        MutableLiveData<List<DummyData>>(listOf(
            DummyData("1"),
            DummyData("2")
        ))
    }

    fun getData(): LiveData<List<DummyData>> {
        return data
    }

}