package com.code.roomdatabase.Model.Book

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.code.roomdatabase.Database.converters.DateConverter
import java.util.*


@Entity(tableName = "books")
class Book (
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val description: String,
    @ColumnInfo(name = "bookGenreId")
    val genreId: String,
    //By marking a property with @TypeConverters room will know it needs to translate and how to do it
    @TypeConverters(DateConverter::class)
    val publishingDate: Date
    //We changed the schema hence we need to migrate the database to a newer verison
)