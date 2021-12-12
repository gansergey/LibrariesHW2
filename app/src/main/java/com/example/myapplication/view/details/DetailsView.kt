package com.example.myapplication.view.details

import com.example.myapplication.model.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface DetailsView : MvpView {

    fun showUser(user: GithubUser)
}