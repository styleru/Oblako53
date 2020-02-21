package com.example.hookahapp.presentation.mainpage

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.example.hookahapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.single_menu_item_fragment.*

class SingleMenuItemFragment : BottomSheetDialogFragment() {
    companion object{
        private const val SCREEN_KEY = "screen_key"

        const val CONTACTS = "contacts"
        const val HOOKAH = "hookah"
        const val PIZZA = "pizza"
        const val DESSERTS = "desserts"
        const val JAPANESE_KITCHEN = "japanese_kitchen"
        const val BEVERAGE = "beverage"
        const val SNACKS = "snacks"
        const val BAR = "bar"
        const val COCKTAILS = "cocktails"

        fun newInstance(key: String) : SingleMenuItemFragment{
            val bundle = Bundle()
            bundle.putString(SCREEN_KEY, key)
            val fragment = SingleMenuItemFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.single_menu_item_fragment, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val key = arguments?.get(SCREEN_KEY)
        when (key) {
            CONTACTS -> Toast.makeText(context, "This page is under development.", Toast.LENGTH_SHORT).show()
            HOOKAH -> menuImageView.setImageResource(R.drawable.hookah_menu)
            PIZZA -> menuImageView.setImageResource(R.drawable.pizza)
            DESSERTS -> menuImageView.setImageResource(R.drawable.desserts)
            JAPANESE_KITCHEN -> menuImageView.setImageResource(R.drawable.japanese_kitchen)
            BEVERAGE -> menuImageView.setImageResource(R.drawable.beverages)
            SNACKS -> menuImageView.setImageResource(R.drawable.snacks)
            BAR -> menuImageView.setImageResource(R.drawable.bar)
            COCKTAILS -> menuImageView.setImageResource(R.drawable.cocktails)
            else -> throw Exception("Unknown key")
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.supportFragmentManager?.beginTransaction()?.remove(this@SingleMenuItemFragment)?.commit()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }
}