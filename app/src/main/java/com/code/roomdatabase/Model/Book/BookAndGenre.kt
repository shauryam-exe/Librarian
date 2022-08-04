package com.code.roomdatabase.Model.Book

import androidx.room.Embedded
import androidx.room.Relation


//Create this class to define the relationship between entities
class BookAndGenre(

    //@Embedded is used to decompose an object into its subfields within a table(entity).
    @Embedded
    val book: Book,

    //@Relation gives instruction on how to create the relation
    //set parentColumn to the field of the parent table you want to create relation from
    //set entityColumn to the field of the child table that should reference the parent entity's table
    //basically we are connecting the value bookGenreId to the id of Genre entity
    @Relation(parentColumn = "bookGenreId", entityColumn = "id")
    val genre: Genre
)