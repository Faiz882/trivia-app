package com.example.triviaapp.repository

import android.app.Application
import com.example.triviaapp.interfaces.QuestionsAndAnswersDao
import com.example.triviaapp.model.QuestionAndAnswers
import com.example.triviaapp.utils.TriviaRoomDB


class LocalRepository(application: Application) {
    private val questionsAndAnswersDao: QuestionsAndAnswersDao
    init {
        val db = TriviaRoomDB.getInstance(application.applicationContext)
        questionsAndAnswersDao = db.questionAndAnswersDao
    }

    val recordfromLocal = questionsAndAnswersDao.getAllRecord()

    suspend fun insertRecord(record: QuestionAndAnswers): Long {
        return questionsAndAnswersDao.insertRecord(record)

    }

    suspend fun updateRecord(record: QuestionAndAnswers): Int {
        return questionsAndAnswersDao.updateRecord(record)
    }

    suspend fun deleteOneRecord(record: QuestionAndAnswers): Int {
        return questionsAndAnswersDao.deleteOneRecord(record)
    }

    suspend fun deleteAllRecords(): Int {
        return questionsAndAnswersDao.deleteAll()
    }

}