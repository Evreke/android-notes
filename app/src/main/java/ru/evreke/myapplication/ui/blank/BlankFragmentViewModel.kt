package ru.evreke.myapplication.ui.blank

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.evreke.myapplication.Api
import ru.evreke.myapplication.Group
import ru.evreke.myapplication.RetrofitService

class BlankFragmentViewModel : ViewModel() {
    private val api by lazy { RetrofitService.apiFrom<Api>("https://notes.evreke.ru/api/v1/") }

    val data: MutableLiveData<List<Group>> by lazy {
        MutableLiveData<List<Group>>()
    }

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            data.postValue(api.fetchAllGroups())
        }
    }

}