package com.code.roomdatabase.Model.Book

import androidx.room.Embedded
import androidx.room.Relation


//Create this class to Define ONE TO MANY Relationship
//One Genre will have many Books, hence there is a List<Book>
class BooksByGenre(

    //put @Embedded on the Parent entity
    @Embedded
    val genre: Genre,

    //Using @Relation just like in the previous example
    @Relation(parentColumn = "id", entityColumn = "bookGenreId")
    val book: List<Book>?
    //The list should be nullable just in case there is no book for a genre

)