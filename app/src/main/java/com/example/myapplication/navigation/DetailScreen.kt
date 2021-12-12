package com.example.myapplication.navigation

import com.example.myapplication.model.GithubUser
import com.example.myapplication.view.details.DetailFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class DetailScreen(private val user: GithubUser) {

    fun create(): Screen {
        return FragmentScreen { DetailFragment.newInstance(user.login) }
    }
}