package com.example.economist_clone.saveddatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [MyEntity::class],version = 1,exportSchema = false)
abstract class MyDatabase():RoomDatabase() {
    abstract fun getMyDao():MyDao
    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java,
                        "details_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}