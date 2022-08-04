package com.code.roomdatabase.repository

import com.code.roomdatabase.Database.Dao.BookDao
import com.code.roomdatabase.Database.Dao.GenreDao
import com.code.roomdatabase.Database.Dao.ReadingListDao
import com.code.roomdatabase.Database.Dao.ReviewDao
import com.code.roomdatabase.Model.Book.Book
import com.code.roomdatabase.Model.Book.BookAndGenre
import com.code.roomdatabase.Model.Book.Genre
import kotlinx.coroutines.flow.Flow


class LibrarianRepositoryImpl(
    private val bookDao: BookDao,
    private val genreDao: GenreDao,
    private val readingListDao: ReadingListDao,
    private val reviewDao: ReviewDao
) : LibrarianRepository {

    //Add the Flow function in the Repository Class, also in the Repository Interface
    override fun getBooksFlow(): Flow<List<Book>> = bookDao.getBooksFlow()

    override suspend fun addBook(book: Book) = bookDao.insertBook(book)

    override suspend fun getGenre(): List<Genre> = genreDao.getGenre()

    override fun getGenreById(genreId: String): Genre = genreDao.getGenreById(genreId)

    override fun addGenre(genres: List<Genre>) = genreDao.addGenre(genres)

}


