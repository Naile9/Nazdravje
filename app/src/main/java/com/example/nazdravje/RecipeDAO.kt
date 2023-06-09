package com.example.nazdravje

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.nazdravje.ui.adapters.RecipeModel
import kotlinx.coroutines.flow.Flow

interface RecipeDAO
{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRecipe(recipe: RecipeModel)

    @Query("SELECT * FROM recipes")
    fun getRecipes(): Flow<List<RecipeModel>>

    @Update
    suspend fun updateRecipe(note: RecipeModel)

    @Delete
    suspend fun deleteRecipe(note: RecipeModel)
}