package com.code.roomdatabase.Database.Dao

import androidx.room.*
import com.code.roomdatabase.Model.Book.BooksByGenre
import com.code.roomdatabase.Model.Book.Genre

@Dao
interface GenreDao {

    //This method requires room to run two queries
    //So the @Transaction annotation automates the process
    @Transaction
    @Query("SELECT * FROM genre")
    fun getBooksByGenres(): List<BooksByGenre>

    @Transaction
    @Query("SELECT * FROM genre WHERE id=:genreId")
    fun getBooksByGenre(genreId: String): BooksByGenre


    //Some more example of adding queries
    @Query("SELECT * FROM genre")
    suspend fun getGenre(): List<Genre>

    //Any SQL queries can be executed here
    @Query("SELECT * FROM genre WHERE id = :genreId")
    fun getGenreById(genreId: String): Genre

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGenre(genres: List<Genre>)
}