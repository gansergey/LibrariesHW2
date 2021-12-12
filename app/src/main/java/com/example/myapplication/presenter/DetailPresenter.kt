package com.example.myapplication.presenter

import com.example.myapplication.model.GithubUser
import com.example.myapplication.model.GithubUsersRepo
import com.example.myapplication.view.details.DetailsView

import moxy.MvpPresenter

class DetailPresenter(
    private val userLogin: String,
    private val gitHubRepo: GithubUsersRepo
) :
    MvpPresenter<DetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        gitHubRepo
            .getUsers()
            .firstOrNull { user: GithubUser -> user.login == userLogin }
            ?.let(viewState::showUser)
    }
}