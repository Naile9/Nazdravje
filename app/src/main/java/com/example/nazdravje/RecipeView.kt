package com.example.nazdravje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.example.nazdravje.databinding.ActivityRecipeViewBinding


class RecipeView : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("Current Recipe", GlobalData.currentRecipe.toString())

        binding.recipeName.text = GlobalData.currentRecipe?.rName!!
        binding.recipeDesc.text = GlobalData.currentRecipe?.rDesc!!
        binding.ingredients.text = GlobalData.currentRecipe?.rIngredients!!
        binding.recipeFav.setOnClickListener {
            val repo = RecipeRepository(binding.root.context)
            val recipe = GlobalData.currentRecipe
            if (recipe != null) {
                repo.addRecipe(recipe = recipe)
            }
        }
    }
}