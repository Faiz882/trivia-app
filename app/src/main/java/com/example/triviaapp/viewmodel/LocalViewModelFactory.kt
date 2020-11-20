package com.example.triviaapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class LocalViewModelFactory(private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LocalViewModel::class.java)){
            return LocalViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}
