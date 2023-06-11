package com.example.nazdravje

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
    interface RecipeDAO {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertRecipe(recipe: Recipe)

        @Query("Select * from recipes")
        fun gelAllRecipe(): List<Recipe>

        @Update
        fun updateRecipe(recipe: Recipe)

//        @Delete
//        fun deleteRecipe(recipe: Recipe)
        @Query("DELETE FROM recipes")
        open fun delete()
    }
