package com.example.hookahapp.presentation.mainpage.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hookahapp.R
import com.example.hookahapp.presentation.mainpage.SingleMenuItemFragment
import com.example.hookahapp.presentation.mainpage.fragments.card.MenuAdapter
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
                activity?.supportFragmentManager?.
                        beginTransaction()?.
                        add(R.id.fragmentHost, SingleMenuItemFragment.newInstance(key))?.commit()
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