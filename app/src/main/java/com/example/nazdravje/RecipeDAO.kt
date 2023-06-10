package com.example.nazdravje

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.nazdravje.ui.adapters.RecipeModel
import kotlinx.coroutines.flow.Flow

    @Dao
    interface RecipeDAO {

        @Insert
        fun insertRecipe(recipe: Recipe)

        @Query("Select * from recipes")
        fun gelAllRecipe(): List<Recipe>

        @Update
        fun updateRecipe(recipe: Recipe)

        @Delete
        fun deleteRecipe(recipe: Recipe)
    }
