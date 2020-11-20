package com.example.triviaapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.triviaapp.model.QuestionAnswersResponseModel
import com.example.triviaapp.repository.ApiRepository

class ApiViewModel:ViewModel() {
    //get doctor detail
    private var questionsMutableLiveData = MutableLiveData<QuestionAnswersResponseModel>()
    fun callQuestionApi(amount:Int, category:Int, difficulty:String, type:String) {
        questionsMutableLiveData =
            ApiRepository.getInstance().getALlQuestions(amount, category,difficulty,type)
    }

    fun getAllQuestions(): LiveData<QuestionAnswersResponseModel> {
        return questionsMutableLiveData
    }

}