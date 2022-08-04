package com.code.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.lifecycleScope
import com.code.roomdatabase.Database.LibrarianDatabase
import com.code.roomdatabase.Model.Book.Genre
import com.code.roomdatabase.repository.LibrarianRepositoryImpl
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

lateinit var repo: LibrarianRepositoryImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Database and Repo Initialization
        val database = LibrarianDatabase.getDatabase(this)
        repo = LibrarianRepositoryImpl(
            database.bookDao(),
            database.genreDao(),
            database.readingListDao(),
            database.reviewDao()
        )
        addGenre()

        //Initializing and calling the Flow function
        val booksFlow by lazy { repo.getBooksFlow() }
        //Collect is a suspend function and can only be called in Coroutine or other suspend function
        lifecycleScope.launchWhenCreated {
            booksFlow.catch { it.printStackTrace() }    //.catch does the error handling
                .collect { booksList ->     //.collect collects the data from the Flow
                    //Do whatever you want with the data
                }
        }



        //The Suspended functions can only be called inside Coroutines or other Suspended functions
        //LifecycleScope binds the Coroutines to the lifecycle of the Activity or Fragment
        lifecycleScope.launch {

            val list = repo.getGenre()

            //Printing the value using Jetpack Compose
            val greeting = findViewById<ComposeView>(R.id.greeting)
            greeting.setContent {
                GenreList(list = list)
            }
        }


    }


    @Composable
    private fun GenreList(list: List<Genre>) {
        Column {
            list.forEach { item ->
                Text(text = item.name)
            }
        }
    }

    private fun addGenre() = lifecycleScope.launch {
        Log.d("Check","Add Genre Working")
            if (repo.getGenre().isEmpty()) {
                repo.addGenre(
                    listOf(
                        Genre(name = "Action",),
                        Genre(name = "Horror",),
                        Genre(name = "Adventure",),
                        Genre(name = "Comedy",),
                        Genre(name = "Fantasy",),
                        Genre(name = "Sci-Fi",),
                        Genre(name = "Romance",),
                        Genre(name = "Biography",),
                        Genre(name = "Poetry",),
                        Genre(name = "Mystery",)
                    )
                )
            }
        }
    }
