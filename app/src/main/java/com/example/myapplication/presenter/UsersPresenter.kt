package com.example.myapplication.presenter

import com.example.myapplication.model.GithubUser
import com.example.myapplication.model.GithubUsersRepo
import com.example.myapplication.navigation.DetailScreen
import com.example.myapplication.view.users.UsersRVAdapter
import com.example.myapplication.view.users.UsersView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UsersPresenter(
    private val model: GithubUsersRepo, private val router: Router
) :
    MvpPresenter<UsersView>() {

    class UsersListPresenter : IUserListPresenter {

        val usersList = mutableListOf<GithubUser>()

        override var itemClickListener: ((UsersRVAdapter.UserItemView) -> Unit)? = null
        override fun getCount() = usersList.size

        override fun bindView(view: UsersRVAdapter.UserItemView) {
            val user = usersList[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    private fun loadData() {

        val users: List<GithubUser> = model.getUsers()
        usersListPresenter.usersList.addAll(users)

        usersListPresenter.itemClickListener = { userItemView: UsersRVAdapter.UserItemView ->
            router.navigateTo(DetailScreen(users[userItemView.pos]).create())
        }
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}