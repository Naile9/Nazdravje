package com.example.nazdravje

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "recipes")
data class Note(
    @PrimaryKey
    @ColumnInfo(name = "dateAdded")
    val dateAdded: Date,
    @ColumnInfo(name = "noteText")
    val noteText: String
)