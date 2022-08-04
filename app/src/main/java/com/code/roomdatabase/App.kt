package com.code.roomdatabase

import android.app.Application
import com.code.roomdatabase.Database.LibrarianDatabase
import com.code.roomdatabase.Model.Book.Genre
import com.code.roomdatabase.repository.LibrarianRepositoryImpl

//Repository and Database is instantiated in this class to access it throughout the application
class App: Application() {

    companion object {
        lateinit var instance: App

        //Instantiate Database
        val database: LibrarianDatabase by lazy {
            LibrarianDatabase.getDatabase(instance)
        }

        //Instantiate Repository
        val repository by lazy {
            LibrarianRepositoryImpl(
                database.bookDao(),
                database.genreDao(),
                database.readingListDao(),
                database.reviewDao()
            )
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

    }
}