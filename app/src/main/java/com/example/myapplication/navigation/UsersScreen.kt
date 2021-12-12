package com.example.myapplication.navigation

import com.example.myapplication.view.users.UsersFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

object UsersScreen {

    fun create(): Screen {
        return FragmentScreen { UsersFragment.newInstance() }
    }
}