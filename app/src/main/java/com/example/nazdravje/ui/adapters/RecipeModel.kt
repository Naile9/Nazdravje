package com.example.nazdravje.ui.adapters

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class  RecipeModel (
    var rName: String,
    var rDesc: String,
    var rIngredients: String,
    var rAuth: String,
)