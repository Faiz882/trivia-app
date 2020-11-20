package com.example.triviaapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_questions_and_answers")
data class QuestionAndAnswers(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "category")
    var category: String = "",

    @ColumnInfo(name = "level")
    var level: String = "",

    @ColumnInfo(name = "type")
    var type: String = "",

    @ColumnInfo(name = "isCorrect")
    var isCorrect: Boolean = false,

    @ColumnInfo(name = "question")
    var question: String = "",

    @ColumnInfo(name = "correctAnswer")
    var answer: String = "",
    @ColumnInfo(name = "answerByUser")
    var answerByUser: String = "",

    )