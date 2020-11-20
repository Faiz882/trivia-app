package com.example.triviaapp.utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.triviaapp.interfaces.QuestionsAndAnswersDao
import com.example.triviaapp.model.QuestionAndAnswers

@Database(entities = [QuestionAndAnswers::class], version = 2, exportSchema = false)

abstract class TriviaRoomDB : RoomDatabase() {
    abstract val questionAndAnswersDao: QuestionsAndAnswersDao

    companion object {
//        @JvmField
//        val MIGRATION_1_2 = Migration1To2()

        @Volatile
        private var INSTANCE: TriviaRoomDB? = null
        fun getInstance(context: Context): TriviaRoomDB {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TriviaRoomDB::class.java,
                        "trivia_game_db"
                    ).build()    // .addMigration(claaName) before build
                }
                return instance
            }
        }

    }
}