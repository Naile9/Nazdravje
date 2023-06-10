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
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDao() : RecipeDAO

    companion object {
        private var INSTANCE: RecipeDatabase? = null

        fun getInstance(context: Context): RecipeDatabase? {
            if (INSTANCE == null) {
                synchronized(RecipeDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        RecipeDatabase::class.java, "recipe.db").allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}