package com.example.triviaapp.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.triviaapp.model.QuestionAndAnswers
import com.example.triviaapp.repository.LocalRepository
import com.example.triviaapp.utils.Event
import kotlinx.coroutines.launch

class LocalViewModel(application: Application) : ViewModel() {

    private var repository = LocalRepository(application)
    private val recordfromLocal = repository.recordfromLocal
    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
        get() = statusMessage

    fun deleteAllRecordfromLocal() {
        clearAllRecordFromLocal()
    }

    fun getAllRecordFromLocal(): LiveData<List<QuestionAndAnswers>> {
        return recordfromLocal
    }

    fun insertRecordInLocal(record: QuestionAndAnswers) = viewModelScope.launch {
        val newRowId = repository.insertRecord(record)
        if (newRowId > -1) {
            statusMessage.value = Event("Record Inserted Successfully $newRowId")
        } else {
            statusMessage.value = Event("Error Occurred")
        }
    }

    fun updateRecordInLocal(record: QuestionAndAnswers) = viewModelScope.launch {
        val noOfRows = repository.updateRecord(record)
    }

    fun deleteRecordFromLocal(record: QuestionAndAnswers) = viewModelScope.launch {
        val noOfRowsDeleted = repository.deleteOneRecord(record)
    }

    fun clearAllRecordFromLocal() = viewModelScope.launch {
        val noOfRowsDeleted = repository.deleteAllRecords()
    }


}