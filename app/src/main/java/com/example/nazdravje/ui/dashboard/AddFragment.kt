package com.example.nazdravje.ui.dashboard

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nazdravje.databinding.FragmentAddBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var title: String = ""
    var description:String = ""
    var ingredients:String = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(AddViewModel::class.java)

        _binding = FragmentAddBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.title.addTextChangedListener (object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                title = s.toString()
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
        binding.description.addTextChangedListener (object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                description = s.toString()
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        binding.ingredients.addTextChangedListener (object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                ingredients = s.toString()
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
        binding.addRecipe.setOnClickListener{
            createRecipe()
        }
//
        return root
    }

    fun createRecipe()
    {
        val db = Firebase.firestore
        // Create a new user with a first and last name
        val recipe = hashMapOf(
            "Author" to "Naile Emini",
            "Description" to description,
            "Title" to title,
            "Ingredients" to ingredients

        )

        // Add a new document with a generated ID
        db.collection("Recipe")
            .add(recipe)
            .addOnSuccessListener { documentReference ->
                Log.d("Firebase", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("Firebase", "Error adding document", e)
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}