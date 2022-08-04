package com.code.roomdatabase.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.code.roomdatabase.Database.Dao.BookDao
import com.code.roomdatabase.Database.Dao.GenreDao
import com.code.roomdatabase.Database.Dao.ReadingListDao
import com.code.roomdatabase.Database.Dao.ReviewDao
import com.code.roomdatabase.Database.Migration.migration_1_2
import com.code.roomdatabase.Database.converters.DateConverter
import com.code.roomdatabase.Model.Book.Book
import com.code.roomdatabase.Model.Book.Genre

//Make sure To change the Database Version
const val databaseVersion = 2

@Database(entities = [Book::class, Genre::class], version = databaseVersion)
@TypeConverters(DateConverter::class)
abstract class LibrarianDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDao
    abstract fun genreDao(): GenreDao
    abstract fun readingListDao(): ReadingListDao
    abstract fun reviewDao(): ReviewDao

    companion object {
        const val databaseName = "Librarian"

        fun getDatabase(context: Context): LibrarianDatabase {
            return Room.databaseBuilder(
                context,
                LibrarianDatabase::class.java,
                databaseName
            )
                //Add the migration using this function and passing in the Migration object created
                .addMigrations(migration_1_2)
                //Also Make Sure to change the database version
                .allowMainThreadQueries()
                .build()
        }
    }
}