package com.example.nazdravje

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    var rName: String,
    val rDesc: String,
    var rIngredients: String,
    val rAuth: String)
