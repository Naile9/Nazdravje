package com.example.nazdravje.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nazdravje.Recipe
import com.example.nazdravje.RecipeDatabase
import com.example.nazdravje.RecipeRepository
import com.example.nazdravje.databinding.RecipeCardBinding
import java.util.ArrayList

class RecipeListAdapter(private var dataSet: ArrayList<RecipeModel>):

    RecyclerView.Adapter<RecipeListAdapter.RecipeHolder>() {
    class RecipeHolder(val binding: RecipeCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(get: RecipeModel) {

            val repo = RecipeRepository(binding.root.context)
            binding.recipeName.text = get.rName
            binding.recipeDesc.text = get.rDesc
            binding.recipeAuthor.text = get.rAuth
            binding.recipeFav.setOnClickListener {
                val recipe = Recipe(rName = get.rName, rDesc = get.rDesc, rAuth = get.rAuth, rIngredients = get.rIngredients)
                repo.addRecipe(recipe = recipe)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        val binding = RecipeCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.bind(dataSet.get(position))
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
    fun setRecipies(users: ArrayList<RecipeModel>) {
        this.dataSet = users
        notifyDataSetChanged()
    }
}