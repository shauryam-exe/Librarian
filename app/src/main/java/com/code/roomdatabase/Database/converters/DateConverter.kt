package com.code.roomdatabase.Database.converters

import androidx.room.TypeConverter
import java.util.*

//Create a new Package Converters in package Database and create this class inside
class DateConverter {

    //@TypeConverter annotation specifies the fun to be a type converter
    //This fun takes in the primitive type from Database and convert it into a Date object
    @TypeConverter
    fun fromTimestamp(value: Long?): Date {
        return Date(value ?: 0)
    }

    //This fun translates a Date object to a long primitive type
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long = date?.time ?: 0
    //Next, Integrate this Converter to the Database

}