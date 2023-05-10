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


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}