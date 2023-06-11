package com.example.nazdravje.ui.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nazdravje.RecipeRepository
import com.example.nazdravje.databinding.FragmentSettingsBinding
import com.example.nazdravje.ui.adapters.RecipeListAdapter
import com.example.nazdravje.ui.adapters.RecipeModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FavoritesFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private lateinit var adapter: RecipeListAdapter
    val repo:RecipeRepository by lazy {
        RecipeRepository(requireContext())
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val favoritesViewModel =
            ViewModelProvider(this)[FavoritesViewModel::class.java]

        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        readRecipe()



        return root
    }


    private fun readRecipe()
    {


        val recipes = arrayListOf<RecipeModel>()

        val favorites = repo.getAllRecipes()

        favorites.forEach { recipe ->
            val current = RecipeModel(
                recipe.rName,
                recipe.rDesc,
                recipe.rIngredients,
                recipe.rAuth
            )
            recipes.add(current)
        }
        binding.recipeFavorites.layoutManager = LinearLayoutManager(this.context)
        adapter = RecipeListAdapter(recipes)
        binding.recipeFavorites.adapter = adapter
//



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}