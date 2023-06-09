package com.example.nazdravje

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nazdravje.ui.adapters.RecipeModel

@Database(
    entities = [RecipeModel::class],
    version = 1,
    exportSchema = true
)
abstract class RecipeDatabase:RoomDatabase(){
    abstract fun recipeDao(): RecipeDAO

    companion object {

        @Volatile
        private var INSTANCE: RecipeDatabase? = null

        fun getDatabase(context: Context): RecipeDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): RecipeDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                RecipeDatabase::class.java,
                "notes_database"
            )
                .build()
        }
    }
}