package com.example.nazdravje.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nazdravje.databinding.FragmentHomeBinding
import com.example.nazdravje.ui.adapters.RecipeListAdapter
import com.example.nazdravje.ui.adapters.RecipeModel
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class HomeFragment : Fragment() {

    private lateinit var adapter: RecipeListAdapter
    private lateinit var user :ArrayList<RecipeModel>
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        userList()
        readRecipe()
        binding.recipeList.layoutManager = LinearLayoutManager(this.context)
        adapter = RecipeListAdapter(user)
        binding.recipeList.adapter = adapter

        return root
    }

    private fun userList(){
        user = arrayListOf(
           RecipeModel(
               "kolac so portokal",
               "Se turat kilo portokali vtava, edna casa ceden sok od portokal,pecivo, jajca, brasno, maslo i se gotvi",
               "Naile Emini",
               "denes"
           ),
            RecipeModel(
                "kolac so portokal",
                "Se turat kilo portokali vtava, edna casa ceden sok od portokal,pecivo, jajca, brasno, maslo i se gotvi",
                "Naile Emini",
                "denes"
            ),
            RecipeModel(
                "kolac so portokal",
                "Se turat kilo portokali vtava, edna casa ceden sok od portokal,pecivo, jajca, brasno, maslo i se gotvi",
                "Naile Emini",
                "denes"
            ),
            RecipeModel(
                "kolac so portokal",
                "Se turat kilo portokali vtava, edna casa ceden sok od portokal,pecivo, jajca, brasno, maslo i se gotvi",
                "Naile Emini",
                "denes"
            )

        )
    }

    fun createRecipe()
    {
        val db = Firebase.firestore
        // Create a new user with a first and last name
        val recipe = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815,
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

    private fun readRecipe()
    {
        val db = Firebase.firestore
        db.collection("Recipe")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("Firebase", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("Firebase", "Error getting documents.", exception)
            }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}