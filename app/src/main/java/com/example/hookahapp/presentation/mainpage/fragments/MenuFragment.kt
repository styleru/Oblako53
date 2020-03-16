package com.example.hookahapp.presentation.mainpage.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hookahapp.R
import com.example.hookahapp.presentation.mainpage.SingleMenuItemFragment
import com.example.hookahapp.presentation.mainpage.SingleMenuItemFragment.Companion.EXIT
import com.example.hookahapp.presentation.mainpage.fragments.card.MenuAdapter
import com.example.hookahapp.presentation.signing.RegOrAuthActivity
import kotlinx.android.synthetic.main.menu_fragment.*

class MenuFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.menu_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        menuRecycler.adapter = MenuAdapter(object : MenuCallback{
            override fun onMenuItemClicked(key: String) {
                if (key == EXIT) {
                    val intent = Intent(requireContext(), RegOrAuthActivity::class.java)
                    requireActivity().startActivity(intent)
                }
                else {
                    val fragment = SingleMenuItemFragment.newInstance(key)
                    fragment.show(fragmentManager!!, "Menu item")
                }
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(): MenuFragment {
            return MenuFragment()
        }
    }
}

interface MenuCallback{
    fun onMenuItemClicked(key: String)
}