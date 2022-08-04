package com.code.roomdatabase.Model.Book

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class Genre(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val name: String
)