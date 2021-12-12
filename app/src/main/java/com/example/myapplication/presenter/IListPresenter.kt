package com.example.myapplication.presenter

import com.example.myapplication.view.users.UsersRVAdapter

interface IListPresenter<V : IItemView> {

    var itemClickListener: ((V) -> Unit)?

    fun bindView(view: V)
    fun getCount(): Int
}

interface IUserListPresenter : IListPresenter<UsersRVAdapter.UserItemView>

interface IItemView {
    var pos: Int
}
