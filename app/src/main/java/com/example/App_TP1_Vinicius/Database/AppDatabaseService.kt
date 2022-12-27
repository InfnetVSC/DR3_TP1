package com.example.App_TP1_Vinicius.Database

import android.content.Context
import androidx.room.Room

class AppDatabaseService {

    companion object{
        var appdataBase : AppDatabase? = null
        val database_name = "appMedicoDatabase.sql"
        fun getInstance(context: Context) : AppDatabase {
            if (appdataBase == null) {
                appdataBase = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    database_name
                )
                    .build()
            }
            return appdataBase as AppDatabase
        }
    }
}