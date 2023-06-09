package com.example.nazdravje.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nazdravje.databinding.RecipeCardBinding
import java.util.ArrayList

class RecipeListAdapter(private val dataSet: ArrayList<RecipeModel>):

    RecyclerView.Adapter<RecipeListAdapter.UserHolder>() {
    class UserHolder(val binding: RecipeCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(get: RecipeModel) {
            binding.recipeName.text = get.rName
            binding.recipeDesc.text = get.rDesc
            binding.recipeAuther.text = get.rAuth
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val binding = RecipeCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return UserHolder(binding)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(dataSet.get(position))
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}