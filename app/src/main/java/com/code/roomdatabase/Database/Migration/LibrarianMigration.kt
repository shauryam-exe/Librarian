package com.code.roomdatabase.Database.Migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


//Create a package Migration inside package Database. Then create file LibrarianMigration and code as follows

//First declare an implementation of the Migration class as a variable. **Note the name of the variable
val migration_1_2 = object: Migration(1, 2) {
    //Then you override the fun as you have to provide a way to migrate data
    override fun migrate(database: SupportSQLiteDatabase) {
        //In the function you run an Sql statement to migrate the data
        database.execSQL("ALTER TABLE books ADD COLUMN publishingDate INTEGER NOT NULL DEFAULT 0")
    }
}
//Now add the migration to the Database.kt