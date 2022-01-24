package com.example.myapplication

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface FirstView: MvpView {
    fun setData(login: String?, password: String?)
    fun showErrorMessage()
}