package com.code.roomdatabase.Database.Dao

import androidx.room.*
import com.code.roomdatabase.Model.Book.Book
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    //Instead of List we return Flow of List of Books
    //This means that everytime the books are updated we will get new books from the database
    @Transaction
    @Query("SELECT * FROM books")
    fun getBooksFlow() : Flow<List<Book>>
    //Also change the Repository


    //The Suspend keyword will tell the room to use Coroutine while executing this function
//    @Query("SELECT * FROM books")
//    suspend fun getBooks(): List<BookAndGenre>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book: Book)

    @Delete
    fun deleteBook(book: Book)

    @Update
    fun updateBook(book: Book)
}



