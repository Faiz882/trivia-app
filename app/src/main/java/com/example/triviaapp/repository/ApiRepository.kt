package com.example.triviaapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.triviaapp.interfaces.ApiInterface
import com.example.triviaapp.model.QuestionAnswersResponseModel
import com.example.triviaapp.utils.RetrofitClientApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiRepository{
    var apiInterface: ApiInterface

    init {
        apiInterface = RetrofitClientApi.createService(ApiInterface::class.java)
    }
    //    companion object{
//            private  var apiRepository: ApiRepository?=null
//        fun getInstance():ApiRepository{
//            if(apiRepository==null){
//                apiRepository = ApiRepository()
//            }
//            return  apiRepository!!
//        }
//    }
    companion object{
        fun getInstance(): ApiRepository {
            val apiRepository: ApiRepository by lazy {
                ApiRepository()
            }
            return apiRepository
        }
    }

    //get all doctors
    private var allQuestionDataSet = MutableLiveData<QuestionAnswersResponseModel>()
    fun getALlQuestions(amount:Int, category:Int, difficulty:String, type:String):MutableLiveData<QuestionAnswersResponseModel>{
        apiInterface.getAllQuestions(amount,category,difficulty,type).enqueue(object :
            Callback<QuestionAnswersResponseModel> {
            override fun onResponse(call: Call<QuestionAnswersResponseModel>, response: Response<QuestionAnswersResponseModel>) {
                if(response.isSuccessful){
                    allQuestionDataSet.value = response.body()
                }

            }
            override fun onFailure(call: Call<QuestionAnswersResponseModel>, t: Throwable) {
                allQuestionDataSet.value = null
            }

        })

        return  allQuestionDataSet
    }



}