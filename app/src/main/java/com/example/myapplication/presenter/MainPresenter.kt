package com.example.myapplication.presenter

import com.example.myapplication.navigation.UsersScreen
import com.example.myapplication.view.main.MainView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(private val router: Router) :
    MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreen.create())
    }

    fun backClicked() {
        router.exit()
    }
}