package com.example.nazdravje.ui.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nazdravje.GlobalData
import com.example.nazdravje.Recipe
import com.example.nazdravje.RecipeRepository
import com.example.nazdravje.RecipeView
import com.example.nazdravje.databinding.RecipeCardBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

import java.util.ArrayList

class RecipeListAdapter(private var dataSet: ArrayList<RecipeModel>):

    RecyclerView.Adapter<RecipeListAdapter.RecipeHolder>() {
    class RecipeHolder(val binding: RecipeCardBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("InvalidAnalyticsName")
        fun bind(get: RecipeModel) {

            val repo = RecipeRepository(binding.root.context)
            binding.recipeName.text = get.rName
            binding.recipeDesc.text = get.rDesc
            binding.recipeAuthor.text = get.rAuth
            binding.recipeFav.setOnClickListener {
                val recipe = Recipe(rName = get.rName, rDesc = get.rDesc, rAuth = get.rAuth, rIngredients = get.rIngredients)
                repo.addRecipe(recipe = recipe)
            }
            binding.cardBg.setOnClickListener {
                GlobalData.currentRecipe = Recipe(1,get.rName,get.rDesc, get.rIngredients, get.rAuth)

                val intent: Intent = Intent(binding.root.context, RecipeView::class.java)
                binding.root.context.startActivity(intent)

                var firebaseAnalytics: FirebaseAnalytics = Firebase.analytics
                firebaseAnalytics.logEvent("recepie_opened") {

                    param("Recepie", "r:" + get.rName)

                }

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