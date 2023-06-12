package com.example.nazdravje

import com.google.firebase.auth.FirebaseUser

object GlobalData {

    var firebaseUser: FirebaseUser? = null
    var isAnonymous: Boolean = false

    var currentRecipe: Recipe? = null
}