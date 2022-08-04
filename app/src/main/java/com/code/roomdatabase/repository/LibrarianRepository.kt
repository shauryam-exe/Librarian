package com.code.roomdatabase.repository

import com.code.roomdatabase.Model.Book.Book
import com.code.roomdatabase.Model.Book.BookAndGenre
import com.code.roomdatabase.Model.Book.Genre
import kotlinx.coroutines.flow.Flow


interface LibrarianRepository {

    fun getBooksFlow(): Flow<List<Book>>

    suspend fun addBook(book: Book)

    suspend fun getGenre(): List<Genre>

    fun getGenreById(genreId: String): Genre

    fun addGenre(genres: List<Genre>)
}
