package com.example.nazdravje

import android.content.Context
import android.os.AsyncTask
import android.util.Log

class RecipeRepository(context: Context) {
    var db: RecipeDAO = RecipeDatabase.getInstance(context)?.recipeDao()!!


    //Fetch All the Users
    fun getAllRecipes(): List<Recipe> {
        return db.gelAllRecipe()
    }

    // Insert new user
    fun addRecipe(recipe: Recipe) {
        insertAsyncTask(db).execute(recipe)
        Log.e("ROOM", recipe.toString())
    }

    // update user
    fun updateRecipe(recipe: Recipe) {
        db.updateRecipe(recipe)
    }

    // Delete user
    fun deleteRecipe() {// recipe: Recipe
//        db.deleteRecipe(recipe)
        db.delete()
    }

    private class insertAsyncTask internal constructor(private val recipeDao: RecipeDAO) :
        AsyncTask<Recipe, Void, Void>() {

        override fun doInBackground(vararg params: Recipe): Void? {
            recipeDao.insertRecipe(params[0])
            return null
        }
    }
}