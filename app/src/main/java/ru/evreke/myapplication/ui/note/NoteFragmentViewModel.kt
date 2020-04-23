package ru.evreke.myapplication.ui.note

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.evreke.myapplication.Api
import ru.evreke.myapplication.Note
import ru.evreke.myapplication.RetrofitService

class NoteFragmentViewModel : ViewModel() {
    private val api by lazy { RetrofitService.apiFrom<Api>("https://notes.evreke.ru/api/v1/") }

    val data: MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>()
    }

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            data.postValue(api.fetchAllNotes())
        }
    }

}