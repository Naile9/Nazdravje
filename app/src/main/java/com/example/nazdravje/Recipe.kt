package com.example.nazdravje

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "recipes", indices = [Index(value = ["rName"], unique = true)])
data class Recipe(
    @PrimaryKey(autoGenerate = true) var recipeID: Int? = null,
    var rName: String,
    val rDesc: String,
    var rIngredients: String,
    val rAuth: String)
